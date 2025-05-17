<!DOCTYPE html>
<html>
<head>
    <title>Database</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        /* Container to hold both sections */
        .container {
            display: flex;
            justify-content: space-between;
            gap: 20px;
        }

        /* Student and teacher sections */
        .student-section, .teacher-section {
            flex: 1;
            border: 1px solid #ccc;
            padding: 20px;
            margin: 10px;
            background-color: #f9f9f9;
        }

        /* Basic styling for buttons and form groups */
        .button-group {
            margin-top: 10px;
        }
        button {
            margin-right: 10px;
            padding: 5px 15px;
        }
        .form-group {
            margin: 10px 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <!-- Student Registration Form -->
        <div class="student-section">
            <form action="/demo/api/students/register" method="post">
                <div class="form-group">
                    <label>ID</label>
                    <input type="text" name="ID"/>
                </div>
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" name="Name"/>
                </div>
                <div class="form-group">
                    <label>Age</label>
                    <input type="text" name="Age"/>
                </div>
                <div class="form-group">
                    <label>GPA</label>
                    <input type="text" name="GPA"/>
                </div>
                <div class="button-group">
                    <button type="submit">Register Student</button>
                </div>
            </form>

            <!-- Print a Single Student -->
            <form action="/demo/api/students/" method="get" onsubmit="event.preventDefault(); location.href=this.action + document.getElementById('studentID').value;">
                <div class="form-group">
                    <label>Student ID to Print</label>
                    <input type="text" name="ID" id="studentID"/>
                </div>
                <div class="button-group">
                    <button type="submit">Print Student</button>
                </div>
            </form>
            

            <!-- Print All Students -->
            <form action="/demo/api/students" method="get">
                <div class="button-group">
                    <button type="submit">Print All Students</button>
                </div>
            </form>

            <!-- Delete a Student -->
            <form action="/demo/api/students/delete" method="post">
                <div class="form-group">
                    <label>Student ID to Delete</label>
                    <input type="text" name="ID"/>
                </div>
                <div class="button-group">
                    <button type="submit">Delete Student</button>
                </div>
            </form>

            <!-- Update a Student -->
            <form action="/demo/api/students/update" method="post">
                <div class="form-group">
                    <label>Student ID to Update</label>
                    <input type="text" name="ID"/>
                </div>
                <div class="form-group">
                    <label>Change Column</label>
                    <input type="text" name="Column"/>
                </div>
                <div class="form-group">
                    <label>Change Value</label>
                    <input type="text" name="Value"/>
                </div>
                <div class="button-group">
                    <button type="submit">Update Student</button>
                </div>
            </form>
        </div>

        <!-- Teacher Actions -->
        <div class="teacher-section">
            <form action="/demo/api/teachers/register" method="post">
                <div class="form-group">
                    <label>Teacher ID</label>
                    <input type="text" name="ID"/>
                </div>
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" name="Name"/>
                </div>
                <div class="form-group">
                    <label>Course Name</label>
                    <input type="text" name="className"/>
                </div>
                <div class="form-group">
                    <label>Age</label>
                    <input type="text" name="Age"/>
                </div>
                <div class="button-group">
                    <button type="submit">Register Teacher</button>
                </div>
            </form>

            <form action="/demo/api/teachers/*" method="get">
                <div class="form-group">
                    <label>Teacher ID to Print</label>
                    <input type="text" name="ID"/>
                </div>
                <div class="button-group">
                    <button type="submit">Print Teacher</button>
                </div>
            </form>

            <form action="/demo/api/teachers" method="get">
                <div class="button-group">
                    <button type="submit">Print All Teachers</button>
                </div>
            </form>

            <form action="/demo/api/teachers/delete" method="post">
                <div class="form-group">
                    <label>Teacher ID to Delete</label>
                    <input type="text" name="ID"/>
                </div>
                <div class="button-group">
                    <button type="submit">Delete Teacher</button>
                </div>
            </form>

            <form action="/demo/api/teachers/update" method="post">
                <div class="form-group">
                    <label>Teacher ID to Update</label>
                    <input type="text" name="ID"/>
                </div>
                <div class="form-group">
                    <label>Change Column</label>
                    <input type="text" name="Column"/>
                </div>
                <div class="form-group">
                    <label>Change Value</label>
                    <input type="text" name="Value"/>
                </div>
                <div class="button-group">
                    <button type="submit">Update Teacher</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>