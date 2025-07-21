<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Welcome</title>
  <style>
    body {
      background-color: #f2f8ff;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      margin: 0;
      padding: 0;
    }

    .center-container {
      text-align: center;
      margin-top: 100px;
    }

    .report-link {
      text-decoration: none;
      color: #007acc;
      font-size: 28px;
      font-weight: bold;
      transition: color 0.3s ease;
    }

    .report-link:hover {
      color: #004080;
    }

    .report-image {
      display: block;
      margin: 20px auto 0;
      width: 150px;
      height: auto;
      border-radius: 10px;
      box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
      transition: transform 0.3s ease;
    }

    .report-link:hover .report-image {
      transform: scale(1.05);
    }
  </style>
</head>

<body>
  <div class="center-container">
    <a href="report" class="report-link">
      Show Report
      <img src="images/report.jpg" alt="Report Image" class="report-image">
    </a>
  </div>
</body>
</html>
