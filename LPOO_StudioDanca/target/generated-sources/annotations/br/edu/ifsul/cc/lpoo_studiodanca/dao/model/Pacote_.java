package br.edu.ifsul.cc.lpoo_studiodanca.dao.model;

import br.edu.ifsul.cc.lpoo_studiodanca.dao.model.ItensContrato;
import br.edu.ifsul.cc.lpoo_studiodanca.dao.model.Modalidade;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-07-30T14:00:38", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Pacote.class)
public class Pacote_ { 

    public static volatile SingularAttribute<Pacote, Double> valor;
    public static volatile ListAttribute<Pacote, ItensContrato> itensContrato;
    public static volatile SingularAttribute<Pacote, Integer> id;
    public static volatile SingularAttribute<Pacote, String> descricao;
    public static volatile SingularAttribute<Pacote, Modalidade> modalidade;

}