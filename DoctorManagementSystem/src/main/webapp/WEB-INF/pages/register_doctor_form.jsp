<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fm" %>

<h1 style="color:green; text-align:center;">Doctor Registration Page</h1>

<fm:form modelAttribute="docVO">
  <table align="center" bgcolor="lightyellow" cellpadding="10">
    <tr>
      <td>Doctor Name:</td>
      <td><fm:input path="dname" /></td>
    </tr>

    <tr>
      <td>Specialization:</td>
      <td><fm:input path="specialization" /></td>
    </tr>
    <tr>
      <td>Fee:</td>
      <td><fm:input path="fee" /></td>
    </tr>
    <tr>
      <td>Qualification:</td>
      <td><fm:input path="qlfy" /></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="register Doctor" />
        <input type="reset" value="Cancel" />
      </td>
    </tr>
  </table>
</fm:form>
