/*
 * This file is generated by jOOQ.
 */
package alex.jooq.tables;

import alex.jooq.Indexes;
import alex.jooq.Keys;
import alex.jooq.Test;
import alex.jooq.tables.records.QrtzSimpropTriggersRecord;
import jakarta.annotation.Generated;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
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
public class QrtzSimpropTriggers extends TableImpl<QrtzSimpropTriggersRecord> {

    private static final long serialVersionUID = -431087433;

    /** The reference instance of <code>test.qrtz_simprop_triggers</code> */
    public static final QrtzSimpropTriggers QRTZ_SIMPROP_TRIGGERS = new QrtzSimpropTriggers();

    /** The class holding records for this type */
    @Override
    public Class<QrtzSimpropTriggersRecord> getRecordType() {
        return QrtzSimpropTriggersRecord.class;
    }

    /** The column <code>test.qrtz_simprop_triggers.SCHED_NAME</code>. */
    public final TableField<QrtzSimpropTriggersRecord, String> SCHED_NAME =
            createField("SCHED_NAME", org.jooq.impl.SQLDataType.VARCHAR(120).nullable(false), this, "");

    /** The column <code>test.qrtz_simprop_triggers.TRIGGER_NAME</code>. */
    public final TableField<QrtzSimpropTriggersRecord, String> TRIGGER_NAME =
            createField("TRIGGER_NAME", org.jooq.impl.SQLDataType.VARCHAR(190).nullable(false), this, "");

    /** The column <code>test.qrtz_simprop_triggers.TRIGGER_GROUP</code>. */
    public final TableField<QrtzSimpropTriggersRecord, String> TRIGGER_GROUP =
            createField("TRIGGER_GROUP", org.jooq.impl.SQLDataType.VARCHAR(190).nullable(false), this, "");

    /** The column <code>test.qrtz_simprop_triggers.STR_PROP_1</code>. */
    public final TableField<QrtzSimpropTriggersRecord, String> STR_PROP_1 =
            createField("STR_PROP_1", org.jooq.impl.SQLDataType.VARCHAR(512), this, "");

    /** The column <code>test.qrtz_simprop_triggers.STR_PROP_2</code>. */
    public final TableField<QrtzSimpropTriggersRecord, String> STR_PROP_2 =
            createField("STR_PROP_2", org.jooq.impl.SQLDataType.VARCHAR(512), this, "");

    /** The column <code>test.qrtz_simprop_triggers.STR_PROP_3</code>. */
    public final TableField<QrtzSimpropTriggersRecord, String> STR_PROP_3 =
            createField("STR_PROP_3", org.jooq.impl.SQLDataType.VARCHAR(512), this, "");

    /** The column <code>test.qrtz_simprop_triggers.INT_PROP_1</code>. */
    public final TableField<QrtzSimpropTriggersRecord, Integer> INT_PROP_1 =
            createField("INT_PROP_1", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /** The column <code>test.qrtz_simprop_triggers.INT_PROP_2</code>. */
    public final TableField<QrtzSimpropTriggersRecord, Integer> INT_PROP_2 =
            createField("INT_PROP_2", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /** The column <code>test.qrtz_simprop_triggers.LONG_PROP_1</code>. */
    public final TableField<QrtzSimpropTriggersRecord, Long> LONG_PROP_1 =
            createField("LONG_PROP_1", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /** The column <code>test.qrtz_simprop_triggers.LONG_PROP_2</code>. */
    public final TableField<QrtzSimpropTriggersRecord, Long> LONG_PROP_2 =
            createField("LONG_PROP_2", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /** The column <code>test.qrtz_simprop_triggers.DEC_PROP_1</code>. */
    public final TableField<QrtzSimpropTriggersRecord, BigDecimal> DEC_PROP_1 =
            createField("DEC_PROP_1", org.jooq.impl.SQLDataType.DECIMAL(13, 4), this, "");

    /** The column <code>test.qrtz_simprop_triggers.DEC_PROP_2</code>. */
    public final TableField<QrtzSimpropTriggersRecord, BigDecimal> DEC_PROP_2 =
            createField("DEC_PROP_2", org.jooq.impl.SQLDataType.DECIMAL(13, 4), this, "");

    /** The column <code>test.qrtz_simprop_triggers.BOOL_PROP_1</code>. */
    public final TableField<QrtzSimpropTriggersRecord, String> BOOL_PROP_1 =
            createField("BOOL_PROP_1", org.jooq.impl.SQLDataType.VARCHAR(1), this, "");

    /** The column <code>test.qrtz_simprop_triggers.BOOL_PROP_2</code>. */
    public final TableField<QrtzSimpropTriggersRecord, String> BOOL_PROP_2 =
            createField("BOOL_PROP_2", org.jooq.impl.SQLDataType.VARCHAR(1), this, "");

    /** Create a <code>test.qrtz_simprop_triggers</code> table reference */
    public QrtzSimpropTriggers() {
        this(DSL.name("qrtz_simprop_triggers"), null);
    }

    /** Create an aliased <code>test.qrtz_simprop_triggers</code> table reference */
    public QrtzSimpropTriggers(String alias) {
        this(DSL.name(alias), QRTZ_SIMPROP_TRIGGERS);
    }

    /** Create an aliased <code>test.qrtz_simprop_triggers</code> table reference */
    public QrtzSimpropTriggers(Name alias) {
        this(alias, QRTZ_SIMPROP_TRIGGERS);
    }

    private QrtzSimpropTriggers(Name alias, Table<QrtzSimpropTriggersRecord> aliased) {
        this(alias, aliased, null);
    }

    private QrtzSimpropTriggers(Name alias, Table<QrtzSimpropTriggersRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.QRTZ_SIMPROP_TRIGGERS_PRIMARY);
    }

    /** {@inheritDoc} */
    @Override
    public UniqueKey<QrtzSimpropTriggersRecord> getPrimaryKey() {
        return Keys.KEY_QRTZ_SIMPROP_TRIGGERS_PRIMARY;
    }

    /** {@inheritDoc} */
    @Override
    public List<UniqueKey<QrtzSimpropTriggersRecord>> getKeys() {
        return Arrays.<UniqueKey<QrtzSimpropTriggersRecord>>asList(Keys.KEY_QRTZ_SIMPROP_TRIGGERS_PRIMARY);
    }

    /** {@inheritDoc} */
    @Override
    public List<ForeignKey<QrtzSimpropTriggersRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<QrtzSimpropTriggersRecord, ?>>asList(Keys.QRTZ_SIMPROP_TRIGGERS_IBFK_1);
    }

    /** {@inheritDoc} */
    @Override
    public QrtzSimpropTriggers as(String alias) {
        return new QrtzSimpropTriggers(DSL.name(alias), this);
    }

    /** {@inheritDoc} */
    @Override
    public QrtzSimpropTriggers as(Name alias) {
        return new QrtzSimpropTriggers(alias, this);
    }

    /** Rename this table */
    @Override
    public QrtzSimpropTriggers rename(String name) {
        return new QrtzSimpropTriggers(DSL.name(name), null);
    }

    /** Rename this table */
    @Override
    public QrtzSimpropTriggers rename(Name name) {
        return new QrtzSimpropTriggers(name, null);
    }
}
