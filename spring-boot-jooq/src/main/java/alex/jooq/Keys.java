/*
 * This file is generated by jOOQ.
*/
package alex.jooq;


import alex.jooq.tables.Customer;
import alex.jooq.tables.Person;
import alex.jooq.tables.School;
import alex.jooq.tables.records.CustomerRecord;
import alex.jooq.tables.records.PersonRecord;
import alex.jooq.tables.records.SchoolRecord;
import javax.annotation.Generated;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>test</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<CustomerRecord, Long> IDENTITY_CUSTOMER = Identities0.IDENTITY_CUSTOMER;
    public static final Identity<PersonRecord, Integer> IDENTITY_PERSON = Identities0.IDENTITY_PERSON;
    public static final Identity<SchoolRecord, Integer> IDENTITY_SCHOOL = Identities0.IDENTITY_SCHOOL;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<CustomerRecord> KEY_CUSTOMER_PRIMARY = UniqueKeys0.KEY_CUSTOMER_PRIMARY;
    public static final UniqueKey<PersonRecord> KEY_PERSON_PRIMARY = UniqueKeys0.KEY_PERSON_PRIMARY;
    public static final UniqueKey<SchoolRecord> KEY_SCHOOL_PRIMARY = UniqueKeys0.KEY_SCHOOL_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 extends AbstractKeys {
        public static Identity<CustomerRecord, Long> IDENTITY_CUSTOMER = createIdentity(Customer.CUSTOMER, Customer.CUSTOMER.ID);
        public static Identity<PersonRecord, Integer> IDENTITY_PERSON = createIdentity(Person.PERSON, Person.PERSON.ID);
        public static Identity<SchoolRecord, Integer> IDENTITY_SCHOOL = createIdentity(School.SCHOOL, School.SCHOOL.ID);
    }

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<CustomerRecord> KEY_CUSTOMER_PRIMARY = createUniqueKey(Customer.CUSTOMER, "KEY_customer_PRIMARY", Customer.CUSTOMER.ID);
        public static final UniqueKey<PersonRecord> KEY_PERSON_PRIMARY = createUniqueKey(Person.PERSON, "KEY_person_PRIMARY", Person.PERSON.ID);
        public static final UniqueKey<SchoolRecord> KEY_SCHOOL_PRIMARY = createUniqueKey(School.SCHOOL, "KEY_school_PRIMARY", School.SCHOOL.ID);
    }
}
