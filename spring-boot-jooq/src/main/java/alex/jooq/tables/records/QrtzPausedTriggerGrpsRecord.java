/*
 * This file is generated by jOOQ.
*/
package alex.jooq.tables.records;


import alex.jooq.tables.QrtzPausedTriggerGrps;
import javax.annotation.Generated;
import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
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
public class QrtzPausedTriggerGrpsRecord extends UpdatableRecordImpl<QrtzPausedTriggerGrpsRecord> implements Record2<String, String> {

    private static final long serialVersionUID = -83324795;

    /**
     * Setter for <code>test.qrtz_paused_trigger_grps.SCHED_NAME</code>.
     */
    public void setSchedName(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>test.qrtz_paused_trigger_grps.SCHED_NAME</code>.
     */
    public String getSchedName() {
        return (String) get(0);
    }

    /**
     * Setter for <code>test.qrtz_paused_trigger_grps.TRIGGER_GROUP</code>.
     */
    public void setTriggerGroup(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>test.qrtz_paused_trigger_grps.TRIGGER_GROUP</code>.
     */
    public String getTriggerGroup() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<String, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return QrtzPausedTriggerGrps.QRTZ_PAUSED_TRIGGER_GRPS.SCHED_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return QrtzPausedTriggerGrps.QRTZ_PAUSED_TRIGGER_GRPS.TRIGGER_GROUP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getSchedName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getTriggerGroup();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getSchedName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getTriggerGroup();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QrtzPausedTriggerGrpsRecord value1(String value) {
        setSchedName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QrtzPausedTriggerGrpsRecord value2(String value) {
        setTriggerGroup(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QrtzPausedTriggerGrpsRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached QrtzPausedTriggerGrpsRecord
     */
    public QrtzPausedTriggerGrpsRecord() {
        super(QrtzPausedTriggerGrps.QRTZ_PAUSED_TRIGGER_GRPS);
    }

    /**
     * Create a detached, initialised QrtzPausedTriggerGrpsRecord
     */
    public QrtzPausedTriggerGrpsRecord(String schedName, String triggerGroup) {
        super(QrtzPausedTriggerGrps.QRTZ_PAUSED_TRIGGER_GRPS);

        set(0, schedName);
        set(1, triggerGroup);
    }
}
