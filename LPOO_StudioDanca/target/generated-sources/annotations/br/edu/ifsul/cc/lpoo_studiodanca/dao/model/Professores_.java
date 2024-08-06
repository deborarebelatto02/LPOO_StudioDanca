package br.edu.ifsul.cc.lpoo_studiodanca.dao.model;

import br.edu.ifsul.cc.lpoo_studiodanca.dao.model.FolhaPagamento;
import br.edu.ifsul.cc.lpoo_studiodanca.dao.model.Modalidade;
import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-08-05T19:42:53", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Professores.class)
public class Professores_ extends Pessoas_ {

    public static volatile ListAttribute<Professores, FolhaPagamento> holerites;
    public static volatile ListAttribute<Professores, Modalidade> modalidades;
    public static volatile SingularAttribute<Professores, Calendar> dataAdmissao;

}