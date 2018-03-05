/*
 * This file is generated by jOOQ.
*/
package alex.jooq.tables;


import alex.jooq.Indexes;
import alex.jooq.Keys;
import alex.jooq.Test;
import alex.jooq.tables.records.SchoolRecord;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class School extends TableImpl<SchoolRecord> {

    private static final long serialVersionUID = 1393021671;

    /**
     * The reference instance of <code>test.school</code>
     */
    public static final School SCHOOL = new School();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SchoolRecord> getRecordType() {
        return SchoolRecord.class;
    }

    /**
     * The column <code>test.school.id</code>.
     */
    public final TableField<SchoolRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>test.school.name</code>.
     */
    public final TableField<SchoolRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * Create a <code>test.school</code> table reference
     */
    public School() {
        this(DSL.name("school"), null);
    }

    /**
     * Create an aliased <code>test.school</code> table reference
     */
    public School(String alias) {
        this(DSL.name(alias), SCHOOL);
    }

    /**
     * Create an aliased <code>test.school</code> table reference
     */
    public School(Name alias) {
        this(alias, SCHOOL);
    }

    private School(Name alias, Table<SchoolRecord> aliased) {
        this(alias, aliased, null);
    }

    private School(Name alias, Table<SchoolRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Test.TEST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.SCHOOL_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<SchoolRecord, Integer> getIdentity() {
        return Keys.IDENTITY_SCHOOL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SchoolRecord> getPrimaryKey() {
        return Keys.KEY_SCHOOL_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SchoolRecord>> getKeys() {
        return Arrays.<UniqueKey<SchoolRecord>>asList(Keys.KEY_SCHOOL_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public School as(String alias) {
        return new School(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public School as(Name alias) {
        return new School(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public School rename(String name) {
        return new School(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public School rename(Name name) {
        return new School(name, null);
    }
}
