import { User } from "../types/user";

type Props = {
  user: User;
};

const Header = ({ user }: Props) => {
  return (
    <header>
      <span>こんにちは、{user.name}さん</span>
      <button
        onClick={() => {
          localStorage.removeItem("token");
          window.location.href = "/login";
        }}
      >
        ログアウト
      </button>
    </header>
  );
};

export default Header;
