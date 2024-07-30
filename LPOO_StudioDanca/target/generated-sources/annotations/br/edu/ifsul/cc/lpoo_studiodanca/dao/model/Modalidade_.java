package br.edu.ifsul.cc.lpoo_studiodanca.dao.model;

import br.edu.ifsul.cc.lpoo_studiodanca.dao.model.Pacote;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-07-30T14:00:38", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Modalidade.class)
public class Modalidade_ { 

    public static volatile ListAttribute<Modalidade, Pacote> pacotes;
    public static volatile SingularAttribute<Modalidade, Integer> id;
    public static volatile SingularAttribute<Modalidade, String> descricao;

}