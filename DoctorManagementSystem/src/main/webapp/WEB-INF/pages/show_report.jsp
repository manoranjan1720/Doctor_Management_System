<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Doctor Report</title>
  <style>
    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background: #f4f9fd;
      margin: 0;
      padding: 20px;
    }

    h1 {
      text-align: center;
      color: #2e8b57;
      margin-bottom: 30px;
    }

    table {
      width: 90%;
      margin: 0 auto;
      border-collapse: collapse;
      box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
      background: #ffffff;
    }

    th, td {
      padding: 12px 15px;
      text-align: center;
      border-bottom: 1px solid #dddddd;
    }

    th {
      background-color: #007acc;
      color: white;
    }

    tr:nth-child(even) {
      background-color: #f2f2f2;
    }

    tr:hover {
      background-color: #e0f7fa;
    }

    a {
      text-decoration: none;
      color: #007acc;
      font-weight: bold;
      display: inline-flex;
      align-items: center;
      gap: 6px;
    }

    a:hover {
      color: #004080;
    }

    .action-icon {
      width: 20px;
      height: 20px;
      vertical-align: middle;
    }

    .button-links {
      text-align: center;
      margin-top: 40px;
    }

    .button-links a {
      margin: 0 20px;
    }

    .nav-icon {
      width: 50px;
      height: 50px;
      transition: transform 0.3s ease;
    }

    .nav-icon:hover {
      transform: scale(1.1);
    }

    .no-data {
      color: red;
      text-align: center;
      margin-top: 40px;
      font-size: 20px;
    }
  </style>
</head>

<body>

<h1>Show Doctor Report</h1>

<c:choose>
  <c:when test="${!empty doctorsList}">
    <table>
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Specialization</th>
        <th>Fee</th>
        <th>Qualification</th>
        <th>Operations</th>
      </tr>

      <c:forEach var="doc" items="${doctorsList}">
        <tr>
          <td>${doc.did}</td>
          <td>${doc.dname}</td>
          <td>${doc.specialization}</td>
          <td>${doc.fee}</td>
          <td>${doc.qlfy}</td>
          <td>
            <a href="edit?did=${doc.did}">
              <img src="images/edit.jpg" class="action-icon" alt="Edit">Edit
            </a>
            |
            <a href="delete?didNo=${doc.did}" onclick="return confirm('Are you sure you want to delete this doctor?')">
  <img src="images/delete.jpg" class="action-icon" alt="Delete">Delete
</a>

          </td>
        </tr>
      </c:forEach>
    </table>
  </c:when>

  <c:otherwise>
    <div class="no-data">No Doctors Are Found</div>
  </c:otherwise>
</c:choose>

<!-- Navigation Links -->
<div class="button-links">
  <a href="register" title="Add Doctor">
    <img src="images/add.jpg" class="nav-icon" alt="Add Doctor">Add Doctor
  </a>
  <br><br>
  <h1 style="color:green;text-align:center">${resultMsg}</h1>
  
  <br><br>
  
  <a href="./" title="Home">
    <img src="images/home.jpg" class="nav-icon" alt="Home">Home
  </a>
</div>

</body>
</html>
