import { BrowserRouter, Route, Routes } from "react-router-dom";
import GetUsers from "./Components/GetUsers";
import PostUsers from "./Components/PostUsers";
import UpdateUsers from "./Components/UpdateUsers";
//token - 572457740032f23a04458a1eb9e573606605346e5ffb532f19a58edecffbe8c7
function App(){

  return(
    <BrowserRouter>
    <Routes>
      <Route path="/" element={<GetUsers/>}></Route>
      <Route path="/AddUser" element={<PostUsers/>}></Route>
      <Route path="/UpdateUser/:id" element={<UpdateUsers/>}></Route>
    </Routes>
    </BrowserRouter>
 
    
  )
}
export default App;