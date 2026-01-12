import { useState } from "react";
import { login } from "../api/authApi";

const LoginPage = () => {
  const [email, setEmail] = useState("");
  const [name, setName] = useState("");

  const handleLogin = async () => {
    const token = await login(email, name);
    localStorage.setItem("token", token);
    window.location.href = "/todos";
  };

  return (
    <div>
      <input placeholder="email" onChange={(e) => setEmail(e.target.value)} />
      <input placeholder="name" onChange={(e) => setName(e.target.value)} />
      <button onClick={handleLogin}>ログイン</button>
    </div>
  );
};

export default LoginPage;
