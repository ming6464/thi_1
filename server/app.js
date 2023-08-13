const express = require("express");
const app = express();
const apiSinhVien = require("./routers/sinhvienRouter");

const bodyParser = require("body-parser");
const port = 3000;

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

app.use("/sinhvien", apiSinhVien);

app.listen(port, (err) => {
  if (err) throw err;

  console.log(" Run port " + port);
});
