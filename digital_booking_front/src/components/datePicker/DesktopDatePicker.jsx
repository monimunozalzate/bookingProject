import React, { useState } from "react";
import { Datepicker, START_DATE } from "@datepicker-react/styled";
import "./DesktopDatePicker.css";

function DesktopDatePicker() {
  const [state, setState] = useState({
    startDate: null,
    endDate: null,
    focusedInput: START_DATE,
  });

  //   function handleDatesChange(data: OnDatesChangeProps) {
  //     if (!data.focusedInput) {
  //       setState({...data, focusedInput: START_DATE})
  //     } else {
  //       setState(data)
  //     }
  //   }

  return (
    <div id="desktopDatePicker">
      <Datepicker
        //   onDatesChange={handleDatesChange}
        startDate={state.startDate} // Date or null
        endDate={state.endDate} // Date or null
        focusedInput={state.focusedInput} // START_DATE, END_DATE or null
        showSelectedDates={false}
        showClose={false}
        showResetDates={false}
        //   numberOfMonths={1}
        //   vertical={true}
      />
    </div>
  );
}

export default DesktopDatePicker;
