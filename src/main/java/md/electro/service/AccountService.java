package md.electro.service;

import md.electro.model.dto.AccountDto;
import md.electro.model.entity.AccountEntity;
import md.electro.model.input.RegisterRequestExtended;
import md.kobalt.security.auth.AuthenticationRequest;
import md.kobalt.security.auth.AuthenticationResponse;
import md.kobalt.security.model.dto.PageParamDto;
import org.springframework.data.domain.Page;

public interface AccountService {

    AuthenticationResponse authenticate(AuthenticationRequest request);


    AccountDto getMyProfile();

    AccountEntity getCurrentAccount();

    Page<AccountDto> accountsPage(PageParamDto pageParamDto);


    void register(RegisterRequestExtended request);
}
