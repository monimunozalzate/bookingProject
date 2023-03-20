import React, { useState } from "react";
import { TimePicker } from "antd";
//import dayjs from "dayjs";
const format = "HH:mm";
import "./TimePickerComponent.css";

const TimePickerComponent = () => {
  const [open, setOpen] = useState(false);
  const handleOpenClose = () => {
    setOpen(!open);
  };
  
  const onChange = (time, timeString) => {
    console.log(time, timeString);
  };

  return (
    <>
      <TimePicker
        use12Hours
        format="h a"
        onChange={onChange}
        placeholder="Seleccionar hora de llegada"
        open={open}
        onClick={handleOpenClose}
        // status="error"
      />
    </>
  );
};

export default TimePickerComponent;
