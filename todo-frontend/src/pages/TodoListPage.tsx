import { useEffect, useState } from "react";
import { getTodos, deleteTodo, createTodo } from "../api/todoApi";
import { Todo } from "../types/todo";
import TodoItem from "../components/TodoItem";
import TodoForm from "../components/TodoForm";
import Header from "../components/Header";
import { useAuth } from "../hooks/useAuth";

const TodoListPage = () => {
  const { user, loading } = useAuth();
  const [todos, setTodos] = useState<Todo[]>([]);

  useEffect(() => {
    getTodos().then(setTodos);
  }, []);

  if (loading) return <div>Loading...</div>;
  if (!user) return null;

  return (
    <>
      <Header user={user} />
      <button onClick={() => (window.location.href = "/todos/new")}>
        新規作成
      </button>
      <TodoForm
        onSubmit={async (data) => {
          await createTodo(data);
          setTodos(await getTodos());
        }}
      />
      <ul>
        {todos.map((todo) => (
          <TodoItem
            key={todo.id}
            todo={todo}
            onDelete={async (id) => {
              await deleteTodo(id);
              setTodos(await getTodos());
            }}
          />
        ))}
      </ul>
    </>
  );
};

export default TodoListPage;
