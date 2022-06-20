/*
 * This file is generated by jOOQ.
 */
package alex.jooq.tables;

import alex.jooq.Indexes;
import alex.jooq.Keys;
import alex.jooq.Test;
import alex.jooq.tables.records.QrtzCronTriggersRecord;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.jooq.Field;
import org.jooq.ForeignKey;
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
public class QrtzCronTriggers extends TableImpl<QrtzCronTriggersRecord> {

    private static final long serialVersionUID = 1502445516;

    /** The reference instance of <code>test.qrtz_cron_triggers</code> */
    public static final QrtzCronTriggers QRTZ_CRON_TRIGGERS = new QrtzCronTriggers();

    /** The class holding records for this type */
    @Override
    public Class<QrtzCronTriggersRecord> getRecordType() {
        return QrtzCronTriggersRecord.class;
    }

    /** The column <code>test.qrtz_cron_triggers.SCHED_NAME</code>. */
    public final TableField<QrtzCronTriggersRecord, String> SCHED_NAME =
            createField("SCHED_NAME", org.jooq.impl.SQLDataType.VARCHAR(120).nullable(false), this, "");

    /** The column <code>test.qrtz_cron_triggers.TRIGGER_NAME</code>. */
    public final TableField<QrtzCronTriggersRecord, String> TRIGGER_NAME =
            createField("TRIGGER_NAME", org.jooq.impl.SQLDataType.VARCHAR(190).nullable(false), this, "");

    /** The column <code>test.qrtz_cron_triggers.TRIGGER_GROUP</code>. */
    public final TableField<QrtzCronTriggersRecord, String> TRIGGER_GROUP =
            createField(
                    "TRIGGER_GROUP", org.jooq.impl.SQLDataType.VARCHAR(190).nullable(false), this, "");

    /** The column <code>test.qrtz_cron_triggers.CRON_EXPRESSION</code>. */
    public final TableField<QrtzCronTriggersRecord, String> CRON_EXPRESSION =
            createField(
                    "CRON_EXPRESSION", org.jooq.impl.SQLDataType.VARCHAR(120).nullable(false), this, "");

    /** The column <code>test.qrtz_cron_triggers.TIME_ZONE_ID</code>. */
    public final TableField<QrtzCronTriggersRecord, String> TIME_ZONE_ID =
            createField("TIME_ZONE_ID", org.jooq.impl.SQLDataType.VARCHAR(80), this, "");

    /** Create a <code>test.qrtz_cron_triggers</code> table reference */
    public QrtzCronTriggers() {
        this(DSL.name("qrtz_cron_triggers"), null);
    }

    /** Create an aliased <code>test.qrtz_cron_triggers</code> table reference */
    public QrtzCronTriggers(String alias) {
        this(DSL.name(alias), QRTZ_CRON_TRIGGERS);
    }

    /** Create an aliased <code>test.qrtz_cron_triggers</code> table reference */
    public QrtzCronTriggers(Name alias) {
        this(alias, QRTZ_CRON_TRIGGERS);
    }

    private QrtzCronTriggers(Name alias, Table<QrtzCronTriggersRecord> aliased) {
        this(alias, aliased, null);
    }

    private QrtzCronTriggers(
            Name alias, Table<QrtzCronTriggersRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.QRTZ_CRON_TRIGGERS_PRIMARY);
    }

    /** {@inheritDoc} */
    @Override
    public UniqueKey<QrtzCronTriggersRecord> getPrimaryKey() {
        return Keys.KEY_QRTZ_CRON_TRIGGERS_PRIMARY;
    }

    /** {@inheritDoc} */
    @Override
    public List<UniqueKey<QrtzCronTriggersRecord>> getKeys() {
        return Arrays.<UniqueKey<QrtzCronTriggersRecord>>asList(Keys.KEY_QRTZ_CRON_TRIGGERS_PRIMARY);
    }

    /** {@inheritDoc} */
    @Override
    public List<ForeignKey<QrtzCronTriggersRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<QrtzCronTriggersRecord, ?>>asList(Keys.QRTZ_CRON_TRIGGERS_IBFK_1);
    }

    /** {@inheritDoc} */
    @Override
    public QrtzCronTriggers as(String alias) {
        return new QrtzCronTriggers(DSL.name(alias), this);
    }

    /** {@inheritDoc} */
    @Override
    public QrtzCronTriggers as(Name alias) {
        return new QrtzCronTriggers(alias, this);
    }

    /** Rename this table */
    @Override
    public QrtzCronTriggers rename(String name) {
        return new QrtzCronTriggers(DSL.name(name), null);
    }

    /** Rename this table */
    @Override
    public QrtzCronTriggers rename(Name name) {
        return new QrtzCronTriggers(name, null);
    }
}
