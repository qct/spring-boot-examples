/*
 * This file is generated by jOOQ.
 */
package alex.jooq.tables.records;

import alex.jooq.tables.School;
import jakarta.annotation.Generated;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;

/** This class is generated by jOOQ. */
@Generated(
        value = {"http://www.jooq.org", "jOOQ version:3.10.7"},
        comments = "This class is generated by jOOQ")
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class SchoolRecord extends UpdatableRecordImpl<SchoolRecord> implements Record2<Integer, String> {

    private static final long serialVersionUID = -1090485018;

    /** Setter for <code>test.school.id</code>. */
    public void setId(Integer value) {
        set(0, value);
    }

    /** Getter for <code>test.school.id</code>. */
    public Integer getId() {
        return (Integer) get(0);
    }

    /** Setter for <code>test.school.name</code>. */
    public void setName(String value) {
        set(1, value);
    }

    /** Getter for <code>test.school.name</code>. */
    public String getName() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /** {@inheritDoc} */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /** {@inheritDoc} */
    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /** {@inheritDoc} */
    @Override
    public Row2<Integer, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /** {@inheritDoc} */
    @Override
    public Field<Integer> field1() {
        return School.SCHOOL.ID;
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field2() {
        return School.SCHOOL.NAME;
    }

    /** {@inheritDoc} */
    @Override
    public Integer component1() {
        return getId();
    }

    /** {@inheritDoc} */
    @Override
    public String component2() {
        return getName();
    }

    /** {@inheritDoc} */
    @Override
    public Integer value1() {
        return getId();
    }

    /** {@inheritDoc} */
    @Override
    public String value2() {
        return getName();
    }

    /** {@inheritDoc} */
    @Override
    public SchoolRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public SchoolRecord value2(String value) {
        setName(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public SchoolRecord values(Integer value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /** Create a detached SchoolRecord */
    public SchoolRecord() {
        super(School.SCHOOL);
    }

    /** Create a detached, initialised SchoolRecord */
    public SchoolRecord(Integer id, String name) {
        super(School.SCHOOL);

        set(0, id);
        set(1, name);
    }
}
