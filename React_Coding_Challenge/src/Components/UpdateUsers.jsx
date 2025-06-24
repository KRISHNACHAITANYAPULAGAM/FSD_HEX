import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

function UpdateUsers() {

    const{id}=useParams();
    let [name, setName] = useState("");
    let [email, setEmail] = useState("");
    let [gender, setGender] = useState("");
    let [status, setStatus] = useState("");
    const navigate=useNavigate();

    useEffect(()=>{
    const getUser=async()=>{
    const res=await axios.get(`https://gorest.co.in/public/v2/users/${id}`)
    console.log(res.data);
    setName(res.data.name);
    setEmail(res.data.email);
    setGender(res.data.gender);
    setStatus(res.data.status);
    }
    getUser();
},[id])

    const validateInput = () => {
        if (gender !== "male" && gender !== "female") {
            alert("Gender must be either 'male' or 'female'.");
            return false;
        }

        if (status !== "active" && status !== "inactive") {
            alert("Status must be either 'active' or 'inactive'.");
            return false;
        }
        return true;
    }

    const updatePost = async () => {
        if (!validateInput()) {
            return
        }
        try {
            const res = await axios.put(`https://gorest.co.in/public/v2/users/${id}`, {
                "name": name,
                "email": email,
                "gender": gender,
                "status": status
            }, {
                headers: { Authorization: "Bearer 572457740032f23a04458a1eb9e573606605346e5ffb532f19a58edecffbe8c7" }
            }
            );
            console.log(res.data);
            navigate("/");
        }
        catch (err) {
            console.error("Error Response:", err.response?.data);
            alert("Adding failed: " + (err.response?.data[0]?.message || "Unknown error"));
        }
    }


    return (
        <div className="container-fluid">
            <div className="row">
                <div className="col-lg-12">
                    <br /><br /><br />
                </div>
            </div>
            <div className="row">
                <div className="col-md-4 offset-3">
                    <div className="card">
                        <div className="card-body">
                            <div>
                                <label>Enter Name:</label>
                                <input type="text" value={name} required onChange={(e) => { setName(e.target.value) }} className="form-control" />
                            </div>
                            <div>
                                <label>Enter Email:</label>
                                <input type="text" value={email} required onChange={(e) => { setEmail(e.target.value) }} className="form-control" />
                            </div>
                            <div>
                                <label>Enter Gender(male/female):</label>
                                <input type="text" value={gender} onChange={(e) => { setGender(e.target.value) }} className="form-control" />
                            </div>
                            <div>
                                <label>Enter Status(active/inactive):</label>
                                <input type="text" value={status} onChange={(e) => { setStatus(e.target.value) }} className="form-control" />
                            </div>
                        </div>
                        <div className="card-footer">
                            <button onClick={() => { updatePost() }}>Update User</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}
export default UpdateUsers;