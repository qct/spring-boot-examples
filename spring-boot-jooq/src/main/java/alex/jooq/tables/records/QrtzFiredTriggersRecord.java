/*
 * This file is generated by jOOQ.
 */
package alex.jooq.tables.records;

import alex.jooq.tables.QrtzFiredTriggers;
import jakarta.annotation.Generated;
import org.jooq.Field;
import org.jooq.Record13;
import org.jooq.Record2;
import org.jooq.Row13;
import org.jooq.impl.UpdatableRecordImpl;

/** This class is generated by jOOQ. */
@Generated(
        value = {"http://www.jooq.org", "jOOQ version:3.10.7"},
        comments = "This class is generated by jOOQ")
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class QrtzFiredTriggersRecord extends UpdatableRecordImpl<QrtzFiredTriggersRecord>
        implements Record13<
                String, String, String, String, String, Long, Long, Integer, String, String, String, String, String> {

    private static final long serialVersionUID = -1648984382;

    /** Setter for <code>test.qrtz_fired_triggers.SCHED_NAME</code>. */
    public void setSchedName(String value) {
        set(0, value);
    }

    /** Getter for <code>test.qrtz_fired_triggers.SCHED_NAME</code>. */
    public String getSchedName() {
        return (String) get(0);
    }

    /** Setter for <code>test.qrtz_fired_triggers.ENTRY_ID</code>. */
    public void setEntryId(String value) {
        set(1, value);
    }

    /** Getter for <code>test.qrtz_fired_triggers.ENTRY_ID</code>. */
    public String getEntryId() {
        return (String) get(1);
    }

    /** Setter for <code>test.qrtz_fired_triggers.TRIGGER_NAME</code>. */
    public void setTriggerName(String value) {
        set(2, value);
    }

    /** Getter for <code>test.qrtz_fired_triggers.TRIGGER_NAME</code>. */
    public String getTriggerName() {
        return (String) get(2);
    }

    /** Setter for <code>test.qrtz_fired_triggers.TRIGGER_GROUP</code>. */
    public void setTriggerGroup(String value) {
        set(3, value);
    }

    /** Getter for <code>test.qrtz_fired_triggers.TRIGGER_GROUP</code>. */
    public String getTriggerGroup() {
        return (String) get(3);
    }

    /** Setter for <code>test.qrtz_fired_triggers.INSTANCE_NAME</code>. */
    public void setInstanceName(String value) {
        set(4, value);
    }

    /** Getter for <code>test.qrtz_fired_triggers.INSTANCE_NAME</code>. */
    public String getInstanceName() {
        return (String) get(4);
    }

    /** Setter for <code>test.qrtz_fired_triggers.FIRED_TIME</code>. */
    public void setFiredTime(Long value) {
        set(5, value);
    }

    /** Getter for <code>test.qrtz_fired_triggers.FIRED_TIME</code>. */
    public Long getFiredTime() {
        return (Long) get(5);
    }

    /** Setter for <code>test.qrtz_fired_triggers.SCHED_TIME</code>. */
    public void setSchedTime(Long value) {
        set(6, value);
    }

    /** Getter for <code>test.qrtz_fired_triggers.SCHED_TIME</code>. */
    public Long getSchedTime() {
        return (Long) get(6);
    }

    /** Setter for <code>test.qrtz_fired_triggers.PRIORITY</code>. */
    public void setPriority(Integer value) {
        set(7, value);
    }

    /** Getter for <code>test.qrtz_fired_triggers.PRIORITY</code>. */
    public Integer getPriority() {
        return (Integer) get(7);
    }

    /** Setter for <code>test.qrtz_fired_triggers.STATE</code>. */
    public void setState(String value) {
        set(8, value);
    }

    /** Getter for <code>test.qrtz_fired_triggers.STATE</code>. */
    public String getState() {
        return (String) get(8);
    }

    /** Setter for <code>test.qrtz_fired_triggers.JOB_NAME</code>. */
    public void setJobName(String value) {
        set(9, value);
    }

    /** Getter for <code>test.qrtz_fired_triggers.JOB_NAME</code>. */
    public String getJobName() {
        return (String) get(9);
    }

    /** Setter for <code>test.qrtz_fired_triggers.JOB_GROUP</code>. */
    public void setJobGroup(String value) {
        set(10, value);
    }

    /** Getter for <code>test.qrtz_fired_triggers.JOB_GROUP</code>. */
    public String getJobGroup() {
        return (String) get(10);
    }

    /** Setter for <code>test.qrtz_fired_triggers.IS_NONCONCURRENT</code>. */
    public void setIsNonconcurrent(String value) {
        set(11, value);
    }

    /** Getter for <code>test.qrtz_fired_triggers.IS_NONCONCURRENT</code>. */
    public String getIsNonconcurrent() {
        return (String) get(11);
    }

    /** Setter for <code>test.qrtz_fired_triggers.REQUESTS_RECOVERY</code>. */
    public void setRequestsRecovery(String value) {
        set(12, value);
    }

    /** Getter for <code>test.qrtz_fired_triggers.REQUESTS_RECOVERY</code>. */
    public String getRequestsRecovery() {
        return (String) get(12);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /** {@inheritDoc} */
    @Override
    public Record2<String, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record13 type implementation
    // -------------------------------------------------------------------------

    /** {@inheritDoc} */
    @Override
    public Row13<String, String, String, String, String, Long, Long, Integer, String, String, String, String, String>
            fieldsRow() {
        return (Row13) super.fieldsRow();
    }

    /** {@inheritDoc} */
    @Override
    public Row13<String, String, String, String, String, Long, Long, Integer, String, String, String, String, String>
            valuesRow() {
        return (Row13) super.valuesRow();
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field1() {
        return QrtzFiredTriggers.QRTZ_FIRED_TRIGGERS.SCHED_NAME;
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field2() {
        return QrtzFiredTriggers.QRTZ_FIRED_TRIGGERS.ENTRY_ID;
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field3() {
        return QrtzFiredTriggers.QRTZ_FIRED_TRIGGERS.TRIGGER_NAME;
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field4() {
        return QrtzFiredTriggers.QRTZ_FIRED_TRIGGERS.TRIGGER_GROUP;
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field5() {
        return QrtzFiredTriggers.QRTZ_FIRED_TRIGGERS.INSTANCE_NAME;
    }

    /** {@inheritDoc} */
    @Override
    public Field<Long> field6() {
        return QrtzFiredTriggers.QRTZ_FIRED_TRIGGERS.FIRED_TIME;
    }

    /** {@inheritDoc} */
    @Override
    public Field<Long> field7() {
        return QrtzFiredTriggers.QRTZ_FIRED_TRIGGERS.SCHED_TIME;
    }

    /** {@inheritDoc} */
    @Override
    public Field<Integer> field8() {
        return QrtzFiredTriggers.QRTZ_FIRED_TRIGGERS.PRIORITY;
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field9() {
        return QrtzFiredTriggers.QRTZ_FIRED_TRIGGERS.STATE;
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field10() {
        return QrtzFiredTriggers.QRTZ_FIRED_TRIGGERS.JOB_NAME;
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field11() {
        return QrtzFiredTriggers.QRTZ_FIRED_TRIGGERS.JOB_GROUP;
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field12() {
        return QrtzFiredTriggers.QRTZ_FIRED_TRIGGERS.IS_NONCONCURRENT;
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field13() {
        return QrtzFiredTriggers.QRTZ_FIRED_TRIGGERS.REQUESTS_RECOVERY;
    }

    /** {@inheritDoc} */
    @Override
    public String component1() {
        return getSchedName();
    }

    /** {@inheritDoc} */
    @Override
    public String component2() {
        return getEntryId();
    }

    /** {@inheritDoc} */
    @Override
    public String component3() {
        return getTriggerName();
    }

    /** {@inheritDoc} */
    @Override
    public String component4() {
        return getTriggerGroup();
    }

    /** {@inheritDoc} */
    @Override
    public String component5() {
        return getInstanceName();
    }

    /** {@inheritDoc} */
    @Override
    public Long component6() {
        return getFiredTime();
    }

    /** {@inheritDoc} */
    @Override
    public Long component7() {
        return getSchedTime();
    }

    /** {@inheritDoc} */
    @Override
    public Integer component8() {
        return getPriority();
    }

    /** {@inheritDoc} */
    @Override
    public String component9() {
        return getState();
    }

    /** {@inheritDoc} */
    @Override
    public String component10() {
        return getJobName();
    }

    /** {@inheritDoc} */
    @Override
    public String component11() {
        return getJobGroup();
    }

    /** {@inheritDoc} */
    @Override
    public String component12() {
        return getIsNonconcurrent();
    }

    /** {@inheritDoc} */
    @Override
    public String component13() {
        return getRequestsRecovery();
    }

    /** {@inheritDoc} */
    @Override
    public String value1() {
        return getSchedName();
    }

    /** {@inheritDoc} */
    @Override
    public String value2() {
        return getEntryId();
    }

    /** {@inheritDoc} */
    @Override
    public String value3() {
        return getTriggerName();
    }

    /** {@inheritDoc} */
    @Override
    public String value4() {
        return getTriggerGroup();
    }

    /** {@inheritDoc} */
    @Override
    public String value5() {
        return getInstanceName();
    }

    /** {@inheritDoc} */
    @Override
    public Long value6() {
        return getFiredTime();
    }

    /** {@inheritDoc} */
    @Override
    public Long value7() {
        return getSchedTime();
    }

    /** {@inheritDoc} */
    @Override
    public Integer value8() {
        return getPriority();
    }

    /** {@inheritDoc} */
    @Override
    public String value9() {
        return getState();
    }

    /** {@inheritDoc} */
    @Override
    public String value10() {
        return getJobName();
    }

    /** {@inheritDoc} */
    @Override
    public String value11() {
        return getJobGroup();
    }

    /** {@inheritDoc} */
    @Override
    public String value12() {
        return getIsNonconcurrent();
    }

    /** {@inheritDoc} */
    @Override
    public String value13() {
        return getRequestsRecovery();
    }

    /** {@inheritDoc} */
    @Override
    public QrtzFiredTriggersRecord value1(String value) {
        setSchedName(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzFiredTriggersRecord value2(String value) {
        setEntryId(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzFiredTriggersRecord value3(String value) {
        setTriggerName(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzFiredTriggersRecord value4(String value) {
        setTriggerGroup(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzFiredTriggersRecord value5(String value) {
        setInstanceName(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzFiredTriggersRecord value6(Long value) {
        setFiredTime(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzFiredTriggersRecord value7(Long value) {
        setSchedTime(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzFiredTriggersRecord value8(Integer value) {
        setPriority(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzFiredTriggersRecord value9(String value) {
        setState(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzFiredTriggersRecord value10(String value) {
        setJobName(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzFiredTriggersRecord value11(String value) {
        setJobGroup(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzFiredTriggersRecord value12(String value) {
        setIsNonconcurrent(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzFiredTriggersRecord value13(String value) {
        setRequestsRecovery(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzFiredTriggersRecord values(
            String value1,
            String value2,
            String value3,
            String value4,
            String value5,
            Long value6,
            Long value7,
            Integer value8,
            String value9,
            String value10,
            String value11,
            String value12,
            String value13) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /** Create a detached QrtzFiredTriggersRecord */
    public QrtzFiredTriggersRecord() {
        super(QrtzFiredTriggers.QRTZ_FIRED_TRIGGERS);
    }

    /** Create a detached, initialised QrtzFiredTriggersRecord */
    public QrtzFiredTriggersRecord(
            String schedName,
            String entryId,
            String triggerName,
            String triggerGroup,
            String instanceName,
            Long firedTime,
            Long schedTime,
            Integer priority,
            String state,
            String jobName,
            String jobGroup,
            String isNonconcurrent,
            String requestsRecovery) {
        super(QrtzFiredTriggers.QRTZ_FIRED_TRIGGERS);

        set(0, schedName);
        set(1, entryId);
        set(2, triggerName);
        set(3, triggerGroup);
        set(4, instanceName);
        set(5, firedTime);
        set(6, schedTime);
        set(7, priority);
        set(8, state);
        set(9, jobName);
        set(10, jobGroup);
        set(11, isNonconcurrent);
        set(12, requestsRecovery);
    }
}
