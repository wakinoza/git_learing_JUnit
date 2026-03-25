package test;

import static org.assertj.core.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import main.example.Employee;

class EmployeeTest {

  @Test
  @DisplayName("CSV形式のストリームから正しくEmployeeリストが生成されること")
  void load_validStream_shouldReturnList() throws Exception {
    String csvData = """
        Taro , Tanaka , taro@example.com
        Ichiro, Suzuki , ichiro@example.com
        """;
    InputStream is = new ByteArrayInputStream(csvData.getBytes());

    List<Employee> actual = Employee.load(is);

    assertThat(actual).hasSize(2).extracting(Employee::firstName, Employee::lastName)
        .containsExactly(tuple("Taro", "Tanaka"), tuple("Ichiro", "Suzuki"));
  }
}
