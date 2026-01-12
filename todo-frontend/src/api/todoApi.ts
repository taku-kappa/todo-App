import api from "../utils/axios";
import { Todo } from "../types/todo";

export const getTodos = async (): Promise<Todo[]> => {
  const res = await api.get("/todos");
  return res.data;
};

export const createTodo = async (data: {
  title: string;
  description?: string;
  dueDate?: string;
  statusId: number;
}) => {
  await api.post("/todos", data);
};

export const updateTodo = async (
  id: number,
  data: Partial<Omit<Todo, "id" | "statusName">>
) => {
  await api.put(`/todos/${id}`, data);
};

export const deleteTodo = async (id: number) => {
  await api.delete(`/todos/${id}`);
};
