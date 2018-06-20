/*
 * This file is generated by jOOQ.
*/
package alex.jooq.tables.records;


import alex.jooq.tables.Customer;
import javax.annotation.Generated;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CustomerRecord extends UpdatableRecordImpl<CustomerRecord> implements Record3<Long, String, String> {

    private static final long serialVersionUID = 1516100753;

    /**
     * Setter for <code>test.customer.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>test.customer.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>test.customer.first_name</code>.
     */
    public void setFirstName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>test.customer.first_name</code>.
     */
    public String getFirstName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>test.customer.last_name</code>.
     */
    public void setLastName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>test.customer.last_name</code>.
     */
    public String getLastName() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Customer.CUSTOMER.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Customer.CUSTOMER.FIRST_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Customer.CUSTOMER.LAST_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getFirstName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getLastName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getFirstName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getLastName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CustomerRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CustomerRecord value2(String value) {
        setFirstName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CustomerRecord value3(String value) {
        setLastName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CustomerRecord values(Long value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CustomerRecord
     */
    public CustomerRecord() {
        super(Customer.CUSTOMER);
    }

    /**
     * Create a detached, initialised CustomerRecord
     */
    public CustomerRecord(Long id, String firstName, String lastName) {
        super(Customer.CUSTOMER);

        set(0, id);
        set(1, firstName);
        set(2, lastName);
    }
}
