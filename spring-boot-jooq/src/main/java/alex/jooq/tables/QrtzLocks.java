/*
 * This file is generated by jOOQ.
 */
package alex.jooq.tables;

import alex.jooq.Indexes;
import alex.jooq.Keys;
import alex.jooq.Test;
import alex.jooq.tables.records.QrtzLocksRecord;
import jakarta.annotation.Generated;
import java.util.Arrays;
import java.util.List;
import org.jooq.Field;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

/** This class is generated by jOOQ. */
@Generated(
        value = {"http://www.jooq.org", "jOOQ version:3.10.7"},
        comments = "This class is generated by jOOQ")
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class QrtzLocks extends TableImpl<QrtzLocksRecord> {

    private static final long serialVersionUID = 1391141653;

    /** The reference instance of <code>test.qrtz_locks</code> */
    public static final QrtzLocks QRTZ_LOCKS = new QrtzLocks();

    /** The class holding records for this type */
    @Override
    public Class<QrtzLocksRecord> getRecordType() {
        return QrtzLocksRecord.class;
    }

    /** The column <code>test.qrtz_locks.SCHED_NAME</code>. */
    public final TableField<QrtzLocksRecord, String> SCHED_NAME =
            createField("SCHED_NAME", org.jooq.impl.SQLDataType.VARCHAR(120).nullable(false), this, "");

    /** The column <code>test.qrtz_locks.LOCK_NAME</code>. */
    public final TableField<QrtzLocksRecord, String> LOCK_NAME =
            createField("LOCK_NAME", org.jooq.impl.SQLDataType.VARCHAR(40).nullable(false), this, "");

    /** Create a <code>test.qrtz_locks</code> table reference */
    public QrtzLocks() {
        this(DSL.name("qrtz_locks"), null);
    }

    /** Create an aliased <code>test.qrtz_locks</code> table reference */
    public QrtzLocks(String alias) {
        this(DSL.name(alias), QRTZ_LOCKS);
    }

    /** Create an aliased <code>test.qrtz_locks</code> table reference */
    public QrtzLocks(Name alias) {
        this(alias, QRTZ_LOCKS);
    }

    private QrtzLocks(Name alias, Table<QrtzLocksRecord> aliased) {
        this(alias, aliased, null);
    }

    private QrtzLocks(Name alias, Table<QrtzLocksRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /** {@inheritDoc} */
    @Override
    public Schema getSchema() {
        return Test.TEST;
    }

    /** {@inheritDoc} */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.QRTZ_LOCKS_PRIMARY);
    }

    /** {@inheritDoc} */
    @Override
    public UniqueKey<QrtzLocksRecord> getPrimaryKey() {
        return Keys.KEY_QRTZ_LOCKS_PRIMARY;
    }

    /** {@inheritDoc} */
    @Override
    public List<UniqueKey<QrtzLocksRecord>> getKeys() {
        return Arrays.<UniqueKey<QrtzLocksRecord>>asList(Keys.KEY_QRTZ_LOCKS_PRIMARY);
    }

    /** {@inheritDoc} */
    @Override
    public QrtzLocks as(String alias) {
        return new QrtzLocks(DSL.name(alias), this);
    }

    /** {@inheritDoc} */
    @Override
    public QrtzLocks as(Name alias) {
        return new QrtzLocks(alias, this);
    }

    /** Rename this table */
    @Override
    public QrtzLocks rename(String name) {
        return new QrtzLocks(DSL.name(name), null);
    }

    /** Rename this table */
    @Override
    public QrtzLocks rename(Name name) {
        return new QrtzLocks(name, null);
    }
}
