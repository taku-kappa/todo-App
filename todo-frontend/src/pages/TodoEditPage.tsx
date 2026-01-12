import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { createTodo, updateTodo, getTodos } from "../api/todoApi";
import { Todo } from "../types/todo";
import TodoForm from "../components/TodoForm";

/**
 * Todo 作成 / 編集画面
 * - id があれば編集
 * - id がなければ新規作成
 */
const TodoEditPage = () => {
  const { id } = useParams<{ id: string }>();
  const navigate = useNavigate();

  const [todo, setTodo] = useState<Todo | null>(null);

  // 編集時：既存Todoを取得
  useEffect(() => {
    if (!id) return;

    getTodos().then((todos) => {
      const target = todos.find((t) => t.id === Number(id));
      if (target) {
        setTodo(target);
      }
    });
  }, [id]);

  return (
    <div>
      <h2>{id ? "Todo編集" : "Todo作成"}</h2>

      <TodoForm
        initialValue={todo}
        onSubmit={async (data) => {
          if (id) {
            await updateTodo(Number(id), data);
          } else {
            await createTodo(data);
          }
          navigate("/todos");
        }}
      />
    </div>
  );
};

export default TodoEditPage;
