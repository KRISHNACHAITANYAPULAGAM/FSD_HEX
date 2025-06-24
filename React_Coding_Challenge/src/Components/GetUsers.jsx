import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

function GetUsers(){
    let[users,setUsers]=useState([])

    useEffect(()=>{
    const getUser=async()=>{
        try{
    const res=await axios.get("https://gorest.co.in/public/v2/users")
    console.log(res.data);
    setUsers(res.data);
    }
    catch(err){
        alert("Fetch Failed")
    }}
    getUser();
},[])

    const onDelete=async(id)=>{
        try{
    const res=await axios.delete("https://gorest.co.in/public/v2/users/"+id,{
        headers : {Authorization : "Bearer 572457740032f23a04458a1eb9e573606605346e5ffb532f19a58edecffbe8c7"}
    })
    console.log(res.data);
    let temp=[...users];
    temp=temp.filter(p=>p.id!==id);
    setUsers(temp)
    }
    catch(err){
        alert("Delete failed."+(err.res?.data[0]?.message))
    }
    }

    return(
        <div>
            <div className="row">
                <div className="col-md-2 offset-4">
                    <br /><br />
                    <div className="card">
                        <div className="card-body">
                            <Link to={"/AddUser"} className="btn btn-primary">AddUser</Link>
                        </div>
                    </div>
                    <br /><br />
                </div>
            </div>
            <table className="table table-striped table-hover">
                <thead>
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">Name</th>
                        <th scope="col">Email</th>
                        <th scope="col">Gender</th>
                        <th scope="col">Status</th>
                        <th scope="col">Delete</th>
                        <th scope="col">Update</th>
                    </tr>
                </thead>
                {
                    users.map((e) => (
                        <tbody key={e.id}>
                            <tr>
                                <th scope="row">{e.id}</th>
                                <td>{e.name}</td>
                                <td>{e.email}</td>
                                <td>{e.gender}</td>
                                <td>{e.status}</td>
                                <td><button className="btn btn-danger" onClick={()=>{onDelete(e.id)}}>delete</button></td>
                                <td><Link to={"/UpdateUser/"+e.id} className="btn btn-secondary">Update</Link></td>
                            </tr>

                        </tbody>
                    ))
                }
                
            </table>
        </div>
    )
}
export default GetUsers;