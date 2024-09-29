package md.electro.repository.specification;

import md.electro.model.entity.AccountEntity;
import md.kobalt.security.repository.specifiaction.FilterCriteria;
import md.kobalt.security.repository.specifiaction.JpaAbstractSpec;

import java.io.Serial;


public class AccountSpecification extends JpaAbstractSpec<AccountEntity> {

    @Serial
    private static final long serialVersionUID = 1L;

    public AccountSpecification(FilterCriteria criteria) {
        super(criteria);
    }
}
