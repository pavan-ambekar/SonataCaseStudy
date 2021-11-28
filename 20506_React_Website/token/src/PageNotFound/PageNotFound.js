import React from "react";
import notFount from "../Assets/404.svg";

const PageNotFound = () => {
  return (
    <div
      className="p-5"
      style={{
        width: "100vw",
        height: "100vh",
        display: "flex",
        alignContent: "center",
        justifyContent: "center",
      }}
    >
      <img
        style={{ width: "auto", height: "100%" }}
        src={notFount}
        alt="Page Not Found"
      />
    </div>
  );
};

export default PageNotFound;
