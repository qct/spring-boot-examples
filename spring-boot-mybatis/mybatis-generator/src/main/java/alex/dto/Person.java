package alex.dto;

public class Person {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column testdb.public.person.id
     *
     * @mbg.generated Sun Nov 26 21:15:27 GST 2023
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column testdb.public.person.name
     *
     * @mbg.generated Sun Nov 26 21:15:27 GST 2023
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column testdb.public.person.address
     *
     * @mbg.generated Sun Nov 26 21:15:27 GST 2023
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column testdb.public.person.age
     *
     * @mbg.generated Sun Nov 26 21:15:27 GST 2023
     */
    private Integer age;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column testdb.public.person.id
     *
     * @return the value of testdb.public.person.id
     *
     * @mbg.generated Sun Nov 26 21:15:27 GST 2023
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb.public.person
     *
     * @mbg.generated Sun Nov 26 21:15:27 GST 2023
     */
    public Person withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column testdb.public.person.id
     *
     * @param id the value for testdb.public.person.id
     *
     * @mbg.generated Sun Nov 26 21:15:27 GST 2023
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column testdb.public.person.name
     *
     * @return the value of testdb.public.person.name
     *
     * @mbg.generated Sun Nov 26 21:15:27 GST 2023
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb.public.person
     *
     * @mbg.generated Sun Nov 26 21:15:27 GST 2023
     */
    public Person withName(String name) {
        this.setName(name);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column testdb.public.person.name
     *
     * @param name the value for testdb.public.person.name
     *
     * @mbg.generated Sun Nov 26 21:15:27 GST 2023
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column testdb.public.person.address
     *
     * @return the value of testdb.public.person.address
     *
     * @mbg.generated Sun Nov 26 21:15:27 GST 2023
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb.public.person
     *
     * @mbg.generated Sun Nov 26 21:15:27 GST 2023
     */
    public Person withAddress(String address) {
        this.setAddress(address);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column testdb.public.person.address
     *
     * @param address the value for testdb.public.person.address
     *
     * @mbg.generated Sun Nov 26 21:15:27 GST 2023
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column testdb.public.person.age
     *
     * @return the value of testdb.public.person.age
     *
     * @mbg.generated Sun Nov 26 21:15:27 GST 2023
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb.public.person
     *
     * @mbg.generated Sun Nov 26 21:15:27 GST 2023
     */
    public Person withAge(Integer age) {
        this.setAge(age);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column testdb.public.person.age
     *
     * @param age the value for testdb.public.person.age
     *
     * @mbg.generated Sun Nov 26 21:15:27 GST 2023
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb.public.person
     *
     * @mbg.generated Sun Nov 26 21:15:27 GST 2023
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", address=").append(address);
        sb.append(", age=").append(age);
        sb.append("]");
        return sb.toString();
    }
}