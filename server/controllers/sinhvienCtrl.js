const SinhVien = require("../modules/Sinhvien");

const CreateElement = async (req, res) => {
  Log("CreateElement");
  try {
    let element = new SinhVien(req.body);
    console.log(element);
    await element.save();
    res.json(1);
  } catch (error) {
    res.json(0);
  }
};

const GetAll = async (req, res, next) => {
  Log("GetAll");

  let list = [];
  try {
    list = await SinhVien.find();
  } catch (error) {}

  return res.json(list);
};

const GetElement = async (req, res) => {
  Log("GetElement");

  try {
    const e = await SinhVien.findOne({ Masv: req.params.msv });
    if (e == null) throw Error;
    res.json(e);
  } catch (error) {
    res.json(0);
  }
};

const UpdateElement = async (req, res) => {
  Log("UpdateElement");

  try {
    const element = await SinhVien.findOne({ Masv: req.params.msv });
    element.set(req.body);
    await element.save();
    return res.json(1);
  } catch (error) {
    return res.json(2);
  }
};

const DeleteElement = async (req, res) => {
  Log("DeleteElement");
  try {
    await SinhVien.deleteOne({ Masv: req.params.msv });
    return res.json(1);
  } catch (error) {
    return res.json(0);
  }
};

const DeleteAll = async (req, res) => {
  Log("DeleteAll");
  try {
    await SinhVien.deleteMany();
    return res.json(1);
  } catch (error) {
    return res.json(0);
  }
};

const Log = (log) => {
  console.log("Sinh viên : " + log);
};

module.exports = {
  GetAll,
  GetElement,
  UpdateElement,
  DeleteElement,
  DeleteAll,
  CreateElement,
};
