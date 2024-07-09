package br.edu.ifsul.cc.lpoo_studiodanca.dao.model;

import br.edu.ifsul.cc.lpoo_studiodanca.dao.model.FormaPgto;
import br.edu.ifsul.cc.lpoo_studiodanca.dao.model.Pagamento;
import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-15T18:01:25", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Contrato.class)
public class Contrato_ { 

    public static volatile SingularAttribute<Contrato, FormaPgto> formaPagamento;
    public static volatile SingularAttribute<Contrato, Double> valorDesconto;
    public static volatile ListAttribute<Contrato, Pagamento> pagamentos;
    public static volatile SingularAttribute<Contrato, Integer> id;
    public static volatile SingularAttribute<Contrato, Calendar> dataInicio;

}