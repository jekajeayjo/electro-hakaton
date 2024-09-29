package md.electro.config;

import md.electro.model.dto.AccountDto;
import md.electro.model.entity.AccountEntity;
import md.electro.model.input.RegisterRequestExtended;
import md.kobalt.security.user.JwtUserDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AppMapper {
    @Mapping(target = "role", ignore = true)
    JwtUserDetails mapToDetails(AccountEntity obj);

    @Mapping(target = "role", source = "role.accountRoleName")
    AccountDto map(AccountEntity obj);

    AccountEntity map(RegisterRequestExtended input);

}
