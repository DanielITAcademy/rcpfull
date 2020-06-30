addEventListener ('load',getAll,false)

/*function createEmployee(){
    var ob=document.getElementById('role');
    ob.addEventListener('click',addEmployee,false);
}*/

function addEmployee(){
    var name = document.getElementById('createEmployee').value;
    var role = document.getElementById('role').value;
    postEmployee(name,role);
   
   
}
function getAll(){
    $.ajax({
        url:"http://localhost:8181/employees",
        method: 'GET',
        dataType:'json',
        contentType: 'application/x-www-form-urlencoded',
success: function (data){
    
    console.log(JSON.stringify(data));
    console.log(data[0].name);
},
error:function (error) {
    console.log(error);
}
});
}

function postEmployee(name,role){
    var employee={
        name : name, 
        role : role,
    }
    $.ajax({
        url:"http://localhost:8181/employees/",
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(employee),
        success: function (newEmployee){
            console.log('Employee Posted',newEmployee);
            getAll();
        },
        error: function (error){
            console.log(error);
        }

    });
}

function updateEmployee(name,role){
    var id = document.getElementById('upEmployee').value;
    var name = document.getElementById('updateEmployee').value;
    var role = document.getElementById('role2').value;
   var employee={
       name:name,
       role:role,
       
   }

    $.ajax({
        url:"http://localhost:8181/employees/"+id,
        method: 'PUT',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(employee),
    succes: function(updateEmployee){
        console.log('Employee updated',updateEmployee);
        getAll();
    },
    error: function (error){
        console.log(error);
    }


    })
}
function deleteEmployee(){
    var id = document.getElementById("delEmployee").value;
   
    $.ajax({
        url:"http://localhost:8181/employees/"+id,
        method: 'DELETE',
       
        success: function (){
            console.log('Delete Posted');
            getAll();
        },
        error: function (error){
            console.log(error);
        }

    });
}
