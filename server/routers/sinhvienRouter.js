const express = require("express");
const router = express.Router();
const ctl = require("../controllers/sinhvienCtrl");

router.get("/", ctl.GetAll);

router.get("/:msv", ctl.GetElement);

router.post("/create", ctl.CreateElement);

router.post("/update/:msv", ctl.UpdateElement);

router.post("/delete/:msv", ctl.DeleteElement);
router.post("/delete", ctl.DeleteAll);

module.exports = router;
