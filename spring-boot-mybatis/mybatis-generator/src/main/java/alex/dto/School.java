package alex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class School {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school.id
     *
     * @mbg.generated Mon Nov 27 23:50:17 GST 2023
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school.name
     *
     * @mbg.generated Mon Nov 27 23:50:17 GST 2023
     */
    private String name;
}