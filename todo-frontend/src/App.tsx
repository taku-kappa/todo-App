import { BrowserRouter, Routes, Route } from "react-router-dom";
import LoginPage from "./pages/LoginPage";
import TodoListPage from "./pages/TodoListPage";
import TodoEditPage from "./pages/TodoEditPage";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/login" element={<LoginPage />} />
        <Route path="/" element={<TodoListPage />} />
        <Route path="/todos/:id/edit" element={<TodoEditPage />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
