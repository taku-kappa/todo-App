import api from "../utils/axios";
import { User } from "../types/user";

export const getMe = async (): Promise<User> => {
  const res = await api.get("/users/me");
  return res.data;
};
