package br.edu.ifsul.cc.lpoo_studiodanca.dao.model;

import br.edu.ifsul.cc.lpoo_studiodanca.dao.model.Alunos;
import br.edu.ifsul.cc.lpoo_studiodanca.dao.model.FormaPgto;
import br.edu.ifsul.cc.lpoo_studiodanca.dao.model.ItensContrato;
import br.edu.ifsul.cc.lpoo_studiodanca.dao.model.Pagamento;
import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-07-30T14:00:38", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Contrato.class)
public class Contrato_ { 

    public static volatile SingularAttribute<Contrato, FormaPgto> formaPagamento;
    public static volatile SingularAttribute<Contrato, Alunos> aluno;
    public static volatile SingularAttribute<Contrato, Double> valorDesconto;
    public static volatile ListAttribute<Contrato, Pagamento> pagamentos;
    public static volatile ListAttribute<Contrato, ItensContrato> itensContrato;
    public static volatile SingularAttribute<Contrato, Integer> id;
    public static volatile SingularAttribute<Contrato, Calendar> dataInicio;

}