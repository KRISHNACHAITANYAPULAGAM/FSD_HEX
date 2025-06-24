import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

function PostUsers() {

    let [name, setName] = useState("");
    let [email, setEmail] = useState("");
    let [gender, setGender] = useState("");
    let [status, setStatus] = useState("");
    const navigate=useNavigate();


    const validateInput = () => {
        if (gender !== "male" && gender !== "female") {
            alert("Gender must be male or female");
            return false;
        }

        if (status !== "active" && status !== "inactive") {
            alert("Status must be active or inactive");
            return false;
        }
        return true;
    }

    const addPost = async () => {
        if (!validateInput()) {
            return
        }
        try {
            const res = await axios.post("https://gorest.co.in/public/v2/users", {
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
                                <input type="text" required onChange={(e) => { setName(e.target.value) }} className="form-control" />
                            </div>
                            <div>
                                <label>Enter Email:</label>
                                <input type="text" required onChange={(e) => { setEmail(e.target.value) }} className="form-control" />
                            </div>
                            <div>
                                <label>Enter Gender(male/female):</label>
                                <select className="form-select" required onChange={(e)=>{setGender(e.target.value)}}>
                                    <option defaultValue={""}>Select Gender</option>
                                    <option value="male">male</option>
                                    <option value="female">female</option>
                                </select>
                            </div>
                            <div>
                                <label>Enter Status(active/inactive):</label>
                                <input type="text" required onChange={(e) => { setStatus(e.target.value.toLowerCase()) }} className="form-control" />
                            </div>
                        </div>
                        <div className="card-footer">
                            <button className="btn btn-primary" onClick={() => { addPost() }}>AddUser</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}
export default PostUsers;