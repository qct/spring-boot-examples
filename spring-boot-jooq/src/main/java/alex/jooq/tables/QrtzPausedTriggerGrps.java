/*
 * This file is generated by jOOQ.
 */
package alex.jooq.tables;

import alex.jooq.Indexes;
import alex.jooq.Keys;
import alex.jooq.Test;
import alex.jooq.tables.records.QrtzPausedTriggerGrpsRecord;
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
public class QrtzPausedTriggerGrps extends TableImpl<QrtzPausedTriggerGrpsRecord> {

    private static final long serialVersionUID = 1314946776;

    /** The reference instance of <code>test.qrtz_paused_trigger_grps</code> */
    public static final QrtzPausedTriggerGrps QRTZ_PAUSED_TRIGGER_GRPS = new QrtzPausedTriggerGrps();

    /** The class holding records for this type */
    @Override
    public Class<QrtzPausedTriggerGrpsRecord> getRecordType() {
        return QrtzPausedTriggerGrpsRecord.class;
    }

    /** The column <code>test.qrtz_paused_trigger_grps.SCHED_NAME</code>. */
    public final TableField<QrtzPausedTriggerGrpsRecord, String> SCHED_NAME =
            createField("SCHED_NAME", org.jooq.impl.SQLDataType.VARCHAR(120).nullable(false), this, "");

    /** The column <code>test.qrtz_paused_trigger_grps.TRIGGER_GROUP</code>. */
    public final TableField<QrtzPausedTriggerGrpsRecord, String> TRIGGER_GROUP =
            createField("TRIGGER_GROUP", org.jooq.impl.SQLDataType.VARCHAR(190).nullable(false), this, "");

    /** Create a <code>test.qrtz_paused_trigger_grps</code> table reference */
    public QrtzPausedTriggerGrps() {
        this(DSL.name("qrtz_paused_trigger_grps"), null);
    }

    /** Create an aliased <code>test.qrtz_paused_trigger_grps</code> table reference */
    public QrtzPausedTriggerGrps(String alias) {
        this(DSL.name(alias), QRTZ_PAUSED_TRIGGER_GRPS);
    }

    /** Create an aliased <code>test.qrtz_paused_trigger_grps</code> table reference */
    public QrtzPausedTriggerGrps(Name alias) {
        this(alias, QRTZ_PAUSED_TRIGGER_GRPS);
    }

    private QrtzPausedTriggerGrps(Name alias, Table<QrtzPausedTriggerGrpsRecord> aliased) {
        this(alias, aliased, null);
    }

    private QrtzPausedTriggerGrps(Name alias, Table<QrtzPausedTriggerGrpsRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.QRTZ_PAUSED_TRIGGER_GRPS_PRIMARY);
    }

    /** {@inheritDoc} */
    @Override
    public UniqueKey<QrtzPausedTriggerGrpsRecord> getPrimaryKey() {
        return Keys.KEY_QRTZ_PAUSED_TRIGGER_GRPS_PRIMARY;
    }

    /** {@inheritDoc} */
    @Override
    public List<UniqueKey<QrtzPausedTriggerGrpsRecord>> getKeys() {
        return Arrays.<UniqueKey<QrtzPausedTriggerGrpsRecord>>asList(Keys.KEY_QRTZ_PAUSED_TRIGGER_GRPS_PRIMARY);
    }

    /** {@inheritDoc} */
    @Override
    public QrtzPausedTriggerGrps as(String alias) {
        return new QrtzPausedTriggerGrps(DSL.name(alias), this);
    }

    /** {@inheritDoc} */
    @Override
    public QrtzPausedTriggerGrps as(Name alias) {
        return new QrtzPausedTriggerGrps(alias, this);
    }

    /** Rename this table */
    @Override
    public QrtzPausedTriggerGrps rename(String name) {
        return new QrtzPausedTriggerGrps(DSL.name(name), null);
    }

    /** Rename this table */
    @Override
    public QrtzPausedTriggerGrps rename(Name name) {
        return new QrtzPausedTriggerGrps(name, null);
    }
}
