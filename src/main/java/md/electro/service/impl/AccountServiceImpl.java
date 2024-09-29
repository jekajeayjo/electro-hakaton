package md.electro.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import md.electro.config.AppMapper;
import md.electro.model.dto.AccountDto;
import md.electro.model.entity.AccountEntity;
import md.electro.model.entity.AccountRoleEntity;
import md.electro.model.enums.AccountRoleEnum;
import md.electro.model.enums.AccountStatusEnum;
import md.electro.model.input.RegisterRequestExtended;
import md.electro.repository.AccountRepository;
import md.electro.repository.AccountRoleRepository;
import md.electro.repository.specification.AccountSpecification;
import md.electro.service.AccountService;
import md.kobalt.security.auth.AuthenticationRequest;
import md.kobalt.security.auth.AuthenticationResponse;
import md.kobalt.security.config.JwtService;
import md.kobalt.security.exception.ForbiddenException;
import md.kobalt.security.exception.JwtAuthenticationException;
import md.kobalt.security.exception.WebTokenException;
import md.kobalt.security.model.dto.PageParamDto;
import md.kobalt.security.repository.specifiaction.FilterCriteria;
import md.kobalt.security.user.JwtUserDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

import static md.kobalt.security.utils.ErrorMessage.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Value("${jwt.token.expired}")
    private Long expiredToken;
    @Value("${jwt.token.refresh.expired}")
    private Long expiredRefreshToken;

    private final AccountRepository accountRepository;
    private final AccountRoleRepository accountRoleRepository;
    private final AppMapper appMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        log.info("Request to auth" + request.toString());
        if (request.getEmail() == null) {
            throw new WebTokenException(EMAIL_REQUIRED.getMessage());
        }
        var user = accountRepository.findByEmail(request.getEmail()).orElseThrow(() -> new JwtAuthenticationException(ID_NOT_FOUND));


        if (!user.getStatus().equals(AccountStatusEnum.ENABLE.getValue())) {
            throw new ForbiddenException(ACCOUNT_NOT_ENABLE.getMessage());
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );


        JwtUserDetails jwtUserDetails = JwtUserDetails.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole().getAccountRoleName())
                .build();

        var jwtToken = jwtService.generateToken(jwtUserDetails, expiredToken);
        var jwtTokenRefresh = jwtService.generateToken(jwtUserDetails, expiredRefreshToken);
        return AuthenticationResponse.builder()
                .acceptToken(jwtToken)
                .refreshToken(jwtTokenRefresh)
                .build();
    }

    @Override
    public AccountDto getMyProfile() {
        AccountEntity accountEntity = getCurrentAccount();
//        List<ProfileSettingsAccountViewEntity> list = profileSettingsAccountViewRepository.findByAccountId(accountEntity.getAccountId());
        AccountDto accountDto = appMapper.map(accountEntity);
//        accountDto.setProfileSetting(list.stream().map(appMapper::map).toList());
        return accountDto;
    }

    @Override
    public AccountEntity getCurrentAccount() {
        JwtUserDetails jwtUserDetails = (JwtUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (jwtUserDetails.getId() != null) {
            AccountEntity accountEntityById = findById(Long.valueOf(jwtUserDetails.getId()));
            AccountEntity accountEntityByEmail = accountRepository.findByEmail(jwtUserDetails.getEmail()).orElseThrow(() -> new JwtAuthenticationException(ACCOUNT_NOT_FOUND));

            if (!AccountRoleEnum.ADMIN.getValue().equals(accountEntityByEmail.getRole().getAccountRoleName())
                    || !accountEntityById.getAccountId().toString().equals(jwtUserDetails.getId())) {
                throw new JwtAuthenticationException(ACCOUNT_IS_NOT_OWNER);
            }
            return accountEntityById;
        }
        return accountRepository.findByEmail(jwtUserDetails.getEmail()).orElseThrow(() -> new JwtAuthenticationException(ACCOUNT_NOT_FOUND));

    }

    @Override
    public Page<AccountDto> accountsPage(PageParamDto pageParamDto) {
        Specification<AccountEntity> masterSpec = null;
        for (FilterCriteria filterCriteria : pageParamDto.getCriteria())
            masterSpec = Specification.where(masterSpec).and(new AccountSpecification(filterCriteria));

        Page<AccountEntity> page = accountRepository.findAll(masterSpec, pageParamDto.getPageRequest());
        Page<AccountDto> pageDto = page.map(r -> {
            AccountDto accountViewDto = appMapper.map(r);

            return accountViewDto;
        });
        return pageDto;
    }

    @Override
    public void register(RegisterRequestExtended request) {
        log.info("Registration  request:" + request.toString());
        log.info("Registration email and password:" + request.getEmail() + ": ", request.getPassword());
        verifyExistedEmailAndUserName(request);
        AccountRoleEntity accountRoleEntity = accountRoleRepository.findByAccountRoleName(AccountRoleEnum.USER.getValue());
        AccountEntity accountEntity = appMapper.map(request);
        accountEntity.setRole(accountRoleEntity);
        accountEntity.setDecodedPass(request.getPassword());
        accountEntity.setPassword(passwordEncoder.encode(request.getPassword()));
        accountEntity = accountRepository.save(accountEntity);


        log.info("Registration  account:" + accountEntity);
    }

    private AccountEntity findById(Long accountId) {
        return accountRepository.findById(accountId).orElseThrow(() -> new JwtAuthenticationException(ID_NOT_FOUND));
    }
    private void verifyExistedEmailAndUserName(RegisterRequestExtended request) {
        AccountEntity existedAccountEntity = accountRepository.findByEmailOrUserName(request.getEmail(), request.getUserName());
        if (existedAccountEntity != null) {
            throw new ForbiddenException("Email or username are already existed");
        }
    }
    private Long generateNumber() {
        Random rand = new Random();
        return rand.nextLong(100000000L);
    }
}
