/*
 * This file is generated by jOOQ.
 */
package alex.jooq.tables.records;

import alex.jooq.tables.QrtzJobDetails;
import jakarta.annotation.Generated;
import org.jooq.Field;
import org.jooq.Record10;
import org.jooq.Record3;
import org.jooq.Row10;
import org.jooq.impl.UpdatableRecordImpl;

/** This class is generated by jOOQ. */
@Generated(
        value = {"http://www.jooq.org", "jOOQ version:3.10.7"},
        comments = "This class is generated by jOOQ")
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class QrtzJobDetailsRecord extends UpdatableRecordImpl<QrtzJobDetailsRecord>
        implements Record10<String, String, String, String, String, String, String, String, String, byte[]> {

    private static final long serialVersionUID = -1550574081;

    /** Setter for <code>test.qrtz_job_details.SCHED_NAME</code>. */
    public void setSchedName(String value) {
        set(0, value);
    }

    /** Getter for <code>test.qrtz_job_details.SCHED_NAME</code>. */
    public String getSchedName() {
        return (String) get(0);
    }

    /** Setter for <code>test.qrtz_job_details.JOB_NAME</code>. */
    public void setJobName(String value) {
        set(1, value);
    }

    /** Getter for <code>test.qrtz_job_details.JOB_NAME</code>. */
    public String getJobName() {
        return (String) get(1);
    }

    /** Setter for <code>test.qrtz_job_details.JOB_GROUP</code>. */
    public void setJobGroup(String value) {
        set(2, value);
    }

    /** Getter for <code>test.qrtz_job_details.JOB_GROUP</code>. */
    public String getJobGroup() {
        return (String) get(2);
    }

    /** Setter for <code>test.qrtz_job_details.DESCRIPTION</code>. */
    public void setDescription(String value) {
        set(3, value);
    }

    /** Getter for <code>test.qrtz_job_details.DESCRIPTION</code>. */
    public String getDescription() {
        return (String) get(3);
    }

    /** Setter for <code>test.qrtz_job_details.JOB_CLASS_NAME</code>. */
    public void setJobClassName(String value) {
        set(4, value);
    }

    /** Getter for <code>test.qrtz_job_details.JOB_CLASS_NAME</code>. */
    public String getJobClassName() {
        return (String) get(4);
    }

    /** Setter for <code>test.qrtz_job_details.IS_DURABLE</code>. */
    public void setIsDurable(String value) {
        set(5, value);
    }

    /** Getter for <code>test.qrtz_job_details.IS_DURABLE</code>. */
    public String getIsDurable() {
        return (String) get(5);
    }

    /** Setter for <code>test.qrtz_job_details.IS_NONCONCURRENT</code>. */
    public void setIsNonconcurrent(String value) {
        set(6, value);
    }

    /** Getter for <code>test.qrtz_job_details.IS_NONCONCURRENT</code>. */
    public String getIsNonconcurrent() {
        return (String) get(6);
    }

    /** Setter for <code>test.qrtz_job_details.IS_UPDATE_DATA</code>. */
    public void setIsUpdateData(String value) {
        set(7, value);
    }

    /** Getter for <code>test.qrtz_job_details.IS_UPDATE_DATA</code>. */
    public String getIsUpdateData() {
        return (String) get(7);
    }

    /** Setter for <code>test.qrtz_job_details.REQUESTS_RECOVERY</code>. */
    public void setRequestsRecovery(String value) {
        set(8, value);
    }

    /** Getter for <code>test.qrtz_job_details.REQUESTS_RECOVERY</code>. */
    public String getRequestsRecovery() {
        return (String) get(8);
    }

    /** Setter for <code>test.qrtz_job_details.JOB_DATA</code>. */
    public void setJobData(byte... value) {
        set(9, value);
    }

    /** Getter for <code>test.qrtz_job_details.JOB_DATA</code>. */
    public byte[] getJobData() {
        return (byte[]) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /** {@inheritDoc} */
    @Override
    public Record3<String, String, String> key() {
        return (Record3) super.key();
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    /** {@inheritDoc} */
    @Override
    public Row10<String, String, String, String, String, String, String, String, String, byte[]> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    /** {@inheritDoc} */
    @Override
    public Row10<String, String, String, String, String, String, String, String, String, byte[]> valuesRow() {
        return (Row10) super.valuesRow();
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field1() {
        return QrtzJobDetails.QRTZ_JOB_DETAILS.SCHED_NAME;
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field2() {
        return QrtzJobDetails.QRTZ_JOB_DETAILS.JOB_NAME;
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field3() {
        return QrtzJobDetails.QRTZ_JOB_DETAILS.JOB_GROUP;
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field4() {
        return QrtzJobDetails.QRTZ_JOB_DETAILS.DESCRIPTION;
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field5() {
        return QrtzJobDetails.QRTZ_JOB_DETAILS.JOB_CLASS_NAME;
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field6() {
        return QrtzJobDetails.QRTZ_JOB_DETAILS.IS_DURABLE;
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field7() {
        return QrtzJobDetails.QRTZ_JOB_DETAILS.IS_NONCONCURRENT;
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field8() {
        return QrtzJobDetails.QRTZ_JOB_DETAILS.IS_UPDATE_DATA;
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field9() {
        return QrtzJobDetails.QRTZ_JOB_DETAILS.REQUESTS_RECOVERY;
    }

    /** {@inheritDoc} */
    @Override
    public Field<byte[]> field10() {
        return QrtzJobDetails.QRTZ_JOB_DETAILS.JOB_DATA;
    }

    /** {@inheritDoc} */
    @Override
    public String component1() {
        return getSchedName();
    }

    /** {@inheritDoc} */
    @Override
    public String component2() {
        return getJobName();
    }

    /** {@inheritDoc} */
    @Override
    public String component3() {
        return getJobGroup();
    }

    /** {@inheritDoc} */
    @Override
    public String component4() {
        return getDescription();
    }

    /** {@inheritDoc} */
    @Override
    public String component5() {
        return getJobClassName();
    }

    /** {@inheritDoc} */
    @Override
    public String component6() {
        return getIsDurable();
    }

    /** {@inheritDoc} */
    @Override
    public String component7() {
        return getIsNonconcurrent();
    }

    /** {@inheritDoc} */
    @Override
    public String component8() {
        return getIsUpdateData();
    }

    /** {@inheritDoc} */
    @Override
    public String component9() {
        return getRequestsRecovery();
    }

    /** {@inheritDoc} */
    @Override
    public byte[] component10() {
        return getJobData();
    }

    /** {@inheritDoc} */
    @Override
    public String value1() {
        return getSchedName();
    }

    /** {@inheritDoc} */
    @Override
    public String value2() {
        return getJobName();
    }

    /** {@inheritDoc} */
    @Override
    public String value3() {
        return getJobGroup();
    }

    /** {@inheritDoc} */
    @Override
    public String value4() {
        return getDescription();
    }

    /** {@inheritDoc} */
    @Override
    public String value5() {
        return getJobClassName();
    }

    /** {@inheritDoc} */
    @Override
    public String value6() {
        return getIsDurable();
    }

    /** {@inheritDoc} */
    @Override
    public String value7() {
        return getIsNonconcurrent();
    }

    /** {@inheritDoc} */
    @Override
    public String value8() {
        return getIsUpdateData();
    }

    /** {@inheritDoc} */
    @Override
    public String value9() {
        return getRequestsRecovery();
    }

    /** {@inheritDoc} */
    @Override
    public byte[] value10() {
        return getJobData();
    }

    /** {@inheritDoc} */
    @Override
    public QrtzJobDetailsRecord value1(String value) {
        setSchedName(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzJobDetailsRecord value2(String value) {
        setJobName(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzJobDetailsRecord value3(String value) {
        setJobGroup(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzJobDetailsRecord value4(String value) {
        setDescription(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzJobDetailsRecord value5(String value) {
        setJobClassName(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzJobDetailsRecord value6(String value) {
        setIsDurable(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzJobDetailsRecord value7(String value) {
        setIsNonconcurrent(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzJobDetailsRecord value8(String value) {
        setIsUpdateData(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzJobDetailsRecord value9(String value) {
        setRequestsRecovery(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzJobDetailsRecord value10(byte... value) {
        setJobData(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzJobDetailsRecord values(
            String value1,
            String value2,
            String value3,
            String value4,
            String value5,
            String value6,
            String value7,
            String value8,
            String value9,
            byte[] value10) {
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
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /** Create a detached QrtzJobDetailsRecord */
    public QrtzJobDetailsRecord() {
        super(QrtzJobDetails.QRTZ_JOB_DETAILS);
    }

    /** Create a detached, initialised QrtzJobDetailsRecord */
    public QrtzJobDetailsRecord(
            String schedName,
            String jobName,
            String jobGroup,
            String description,
            String jobClassName,
            String isDurable,
            String isNonconcurrent,
            String isUpdateData,
            String requestsRecovery,
            byte[] jobData) {
        super(QrtzJobDetails.QRTZ_JOB_DETAILS);

        set(0, schedName);
        set(1, jobName);
        set(2, jobGroup);
        set(3, description);
        set(4, jobClassName);
        set(5, isDurable);
        set(6, isNonconcurrent);
        set(7, isUpdateData);
        set(8, requestsRecovery);
        set(9, jobData);
    }
}
