import { useEffect, useState } from "react";
import { Todo } from "../types/todo";

type Props = {
  initialValue?: Todo | null;
  onSubmit: (data: {
    title: string;
    description?: string;
    dueDate?: string;
    statusId: number;
  }) => void;
};

const TodoForm = ({ initialValue, onSubmit }: Props) => {
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [statusId, setStatusId] = useState(1);

  useEffect(() => {
    if (!initialValue) return;

    setTitle(initialValue.title);
    setDescription(initialValue.description ?? "");
    setStatusId(initialValue.statusId);
  }, [initialValue]);

  return (
    <form
      onSubmit={(e) => {
        e.preventDefault();
        onSubmit({
          title,
          description,
          statusId,
        });
      }}
    >
      <div>
        <input
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          placeholder="タイトル"
          required
        />
      </div>

      <div>
        <textarea
          value={description}
          onChange={(e) => setDescription(e.target.value)}
          placeholder="詳細"
        />
      </div>

      <div>
        <select
          value={statusId}
          onChange={(e) => setStatusId(Number(e.target.value))}
        >
          <option value={1}>未着手</option>
          <option value={2}>進行中</option>
          <option value={3}>完了</option>
        </select>
      </div>

      <button type="submit">追加</button>
    </form>
  );
};

export default TodoForm;
