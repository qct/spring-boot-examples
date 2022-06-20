/*
 * This file is generated by jOOQ.
 */
package alex.jooq.tables;

import alex.jooq.Indexes;
import alex.jooq.Keys;
import alex.jooq.Test;
import alex.jooq.tables.records.QrtzFiredTriggersRecord;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
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
public class QrtzFiredTriggers extends TableImpl<QrtzFiredTriggersRecord> {

    private static final long serialVersionUID = 838126804;

    /** The reference instance of <code>test.qrtz_fired_triggers</code> */
    public static final QrtzFiredTriggers QRTZ_FIRED_TRIGGERS = new QrtzFiredTriggers();

    /** The class holding records for this type */
    @Override
    public Class<QrtzFiredTriggersRecord> getRecordType() {
        return QrtzFiredTriggersRecord.class;
    }

    /** The column <code>test.qrtz_fired_triggers.SCHED_NAME</code>. */
    public final TableField<QrtzFiredTriggersRecord, String> SCHED_NAME =
            createField("SCHED_NAME", org.jooq.impl.SQLDataType.VARCHAR(120).nullable(false), this, "");

    /** The column <code>test.qrtz_fired_triggers.ENTRY_ID</code>. */
    public final TableField<QrtzFiredTriggersRecord, String> ENTRY_ID =
            createField("ENTRY_ID", org.jooq.impl.SQLDataType.VARCHAR(95).nullable(false), this, "");

    /** The column <code>test.qrtz_fired_triggers.TRIGGER_NAME</code>. */
    public final TableField<QrtzFiredTriggersRecord, String> TRIGGER_NAME =
            createField("TRIGGER_NAME", org.jooq.impl.SQLDataType.VARCHAR(190).nullable(false), this, "");

    /** The column <code>test.qrtz_fired_triggers.TRIGGER_GROUP</code>. */
    public final TableField<QrtzFiredTriggersRecord, String> TRIGGER_GROUP =
            createField(
                    "TRIGGER_GROUP", org.jooq.impl.SQLDataType.VARCHAR(190).nullable(false), this, "");

    /** The column <code>test.qrtz_fired_triggers.INSTANCE_NAME</code>. */
    public final TableField<QrtzFiredTriggersRecord, String> INSTANCE_NAME =
            createField(
                    "INSTANCE_NAME", org.jooq.impl.SQLDataType.VARCHAR(190).nullable(false), this, "");

    /** The column <code>test.qrtz_fired_triggers.FIRED_TIME</code>. */
    public final TableField<QrtzFiredTriggersRecord, Long> FIRED_TIME =
            createField("FIRED_TIME", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /** The column <code>test.qrtz_fired_triggers.SCHED_TIME</code>. */
    public final TableField<QrtzFiredTriggersRecord, Long> SCHED_TIME =
            createField("SCHED_TIME", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /** The column <code>test.qrtz_fired_triggers.PRIORITY</code>. */
    public final TableField<QrtzFiredTriggersRecord, Integer> PRIORITY =
            createField("PRIORITY", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /** The column <code>test.qrtz_fired_triggers.STATE</code>. */
    public final TableField<QrtzFiredTriggersRecord, String> STATE =
            createField("STATE", org.jooq.impl.SQLDataType.VARCHAR(16).nullable(false), this, "");

    /** The column <code>test.qrtz_fired_triggers.JOB_NAME</code>. */
    public final TableField<QrtzFiredTriggersRecord, String> JOB_NAME =
            createField("JOB_NAME", org.jooq.impl.SQLDataType.VARCHAR(190), this, "");

    /** The column <code>test.qrtz_fired_triggers.JOB_GROUP</code>. */
    public final TableField<QrtzFiredTriggersRecord, String> JOB_GROUP =
            createField("JOB_GROUP", org.jooq.impl.SQLDataType.VARCHAR(190), this, "");

    /** The column <code>test.qrtz_fired_triggers.IS_NONCONCURRENT</code>. */
    public final TableField<QrtzFiredTriggersRecord, String> IS_NONCONCURRENT =
            createField("IS_NONCONCURRENT", org.jooq.impl.SQLDataType.VARCHAR(1), this, "");

    /** The column <code>test.qrtz_fired_triggers.REQUESTS_RECOVERY</code>. */
    public final TableField<QrtzFiredTriggersRecord, String> REQUESTS_RECOVERY =
            createField("REQUESTS_RECOVERY", org.jooq.impl.SQLDataType.VARCHAR(1), this, "");

    /** Create a <code>test.qrtz_fired_triggers</code> table reference */
    public QrtzFiredTriggers() {
        this(DSL.name("qrtz_fired_triggers"), null);
    }

    /** Create an aliased <code>test.qrtz_fired_triggers</code> table reference */
    public QrtzFiredTriggers(String alias) {
        this(DSL.name(alias), QRTZ_FIRED_TRIGGERS);
    }

    /** Create an aliased <code>test.qrtz_fired_triggers</code> table reference */
    public QrtzFiredTriggers(Name alias) {
        this(alias, QRTZ_FIRED_TRIGGERS);
    }

    private QrtzFiredTriggers(Name alias, Table<QrtzFiredTriggersRecord> aliased) {
        this(alias, aliased, null);
    }

    private QrtzFiredTriggers(
            Name alias, Table<QrtzFiredTriggersRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(
                Indexes.QRTZ_FIRED_TRIGGERS_IDX_QRTZ_FT_INST_JOB_REQ_RCVRY,
                Indexes.QRTZ_FIRED_TRIGGERS_IDX_QRTZ_FT_JG,
                Indexes.QRTZ_FIRED_TRIGGERS_IDX_QRTZ_FT_J_G,
                Indexes.QRTZ_FIRED_TRIGGERS_IDX_QRTZ_FT_TG,
                Indexes.QRTZ_FIRED_TRIGGERS_IDX_QRTZ_FT_TRIG_INST_NAME,
                Indexes.QRTZ_FIRED_TRIGGERS_IDX_QRTZ_FT_T_G,
                Indexes.QRTZ_FIRED_TRIGGERS_PRIMARY);
    }

    /** {@inheritDoc} */
    @Override
    public UniqueKey<QrtzFiredTriggersRecord> getPrimaryKey() {
        return Keys.KEY_QRTZ_FIRED_TRIGGERS_PRIMARY;
    }

    /** {@inheritDoc} */
    @Override
    public List<UniqueKey<QrtzFiredTriggersRecord>> getKeys() {
        return Arrays.<UniqueKey<QrtzFiredTriggersRecord>>asList(Keys.KEY_QRTZ_FIRED_TRIGGERS_PRIMARY);
    }

    /** {@inheritDoc} */
    @Override
    public QrtzFiredTriggers as(String alias) {
        return new QrtzFiredTriggers(DSL.name(alias), this);
    }

    /** {@inheritDoc} */
    @Override
    public QrtzFiredTriggers as(Name alias) {
        return new QrtzFiredTriggers(alias, this);
    }

    /** Rename this table */
    @Override
    public QrtzFiredTriggers rename(String name) {
        return new QrtzFiredTriggers(DSL.name(name), null);
    }

    /** Rename this table */
    @Override
    public QrtzFiredTriggers rename(Name name) {
        return new QrtzFiredTriggers(name, null);
    }
}
