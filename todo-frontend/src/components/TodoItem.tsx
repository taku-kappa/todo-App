import { Todo } from "../types/todo";
import { useNavigate } from "react-router-dom";

type Props = {
  todo: Todo;
  onDelete: (id: number) => void;
};

const TodoItem = ({ todo, onDelete }: Props) => {
  const navigate = useNavigate();

  return (
    <li>
      <strong>{todo.title}</strong>（{todo.statusName}）
      <button onClick={() => navigate(`/todos/${todo.id}`)}>編集</button>
      <button onClick={() => onDelete(todo.id)}>削除</button>
    </li>
  );
};

export default TodoItem;
