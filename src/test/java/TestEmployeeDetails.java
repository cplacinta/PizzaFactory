import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class TestEmployeeDetails {
  private EmployeeDetails employee;

  @BeforeMethod
  public void setUp(){
    employee = new EmployeeDetails();
    System.out.println(employee.getCount());
  }

  public void testCalculateAppraisal() {
    employee.setMonthlySalary(8000);
    double appraisal = EmpBusinessLogic.calculateAppraisal(employee);
    Assert.assertEquals(appraisal, 500D, "Expected 500, but got " + appraisal);
    EmployeeDetails newobj = new EmployeeDetails();
    System.out.println(newobj.getCount());
  }

  public void testCalculateYearlySalary() {
    employee.setMonthlySalary(8000);
    double salary = EmpBusinessLogic.calculateYearlySalary(employee);
    Assert.assertEquals(salary, 96000D, "8000");
  }
}