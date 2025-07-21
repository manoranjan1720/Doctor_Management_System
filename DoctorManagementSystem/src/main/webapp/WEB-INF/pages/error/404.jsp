<%@ page isELIgnored="false" isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
    <title>Error - Application</title>
    
    <style>
        body {
            background-color: #f2f2f2;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
        }

        .error-container {
            max-width: 700px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff3cd;
            border: 1px solid #ffeeba;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0,0,0,0.2);
            animation: slideDown 0.6s ease-out;
        }

        @keyframes slideDown {
            from {
                opacity: 0;
                transform: translateY(-20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        h1 {
            color: #dc3545;
            text-align: center;
        }

        h3 {
            color: #28a745;
            text-align: center;
            margin-bottom: 30px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        td {
            padding: 12px;
            border: 1px solid #dee2e6;
        }

        td:first-child {
            font-weight: bold;
            background-color: #fff9e6;
            width: 30%;
        }

        td:last-child {
            background-color: #ffffff;
        }

        .fade-in {
            opacity: 0;
            animation: fadeIn 1s forwards;
        }

        @keyframes fadeIn {
            to { opacity: 1; }
        }
    </style>

    <script>
        window.onload = function () {
            const rows = document.querySelectorAll("table tr");
            rows.forEach((row, index) => {
                row.classList.add("fade-in");
                row.style.animationDelay = `${index * 0.3}s`;
            });
        };
    </script>
</head>
<body>
    <div class="error-container">
        <h1>Error (404 Error Page)</h1>
        <h3>Internal Problem (Client Side error) -- Try Again</h3>

        <table>
            <tr>
                <td>Status</td>
                <td>${status}</td>
            </tr>
            <tr>
                <td>Message</td>
                <td>${message}</td>
            </tr>
            <tr>
                <td>Path</td>
                <td>${path}</td>
            </tr>
            <tr>
                <td>Timestamp</td>
                <td>${timestamp}</td>
            </tr>
        </table>
    </div>
</body>
</html>
