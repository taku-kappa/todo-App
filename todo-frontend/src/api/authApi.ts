import api from "../utils/axios";

export const login = async (email: string, name: string): Promise<string> => {
  const res = await api.post("/auth/login", { email, name });
  return res.data.token;
};
