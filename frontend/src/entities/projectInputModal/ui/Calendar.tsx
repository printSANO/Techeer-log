import { useState } from 'react';
import Calendars from 'react-calendar';
//import 'react-calendar/dist/Calendar.css';
import '../Calendar.css';
import moment from 'moment';

type ValuePiece = Date | null;
type Value = ValuePiece | [ValuePiece, ValuePiece];

export const Calendar = ({ onChange }: any) => {
  const today = new Date();
  const [date, setDate] = useState<Value>(today);

  const handleDateChange = (selectedDate: any) => {
    onChange(selectedDate);
    setDate(selectedDate);
  };

  return (
    <div className="w-max absolute mt-[3.5rem]">
      <Calendars
        value={date}
        onChange={handleDateChange}
        formatDay={(_, date) => moment(date).format('D')} // 일 제거 숫자만 보이게
        formatYear={(_, date) => moment(date).format('YYYY')} // 네비게이션 눌렀을때 숫자 년도만 보이게
        formatMonthYear={(_, date) => moment(date).format('YYYY. MM')} // 네비게이션에서 2023. 12 이렇게 보이도록 설정
        calendarType="gregory" // 일요일 부터 시작
        showNeighboringMonth={false} // 전달, 다음달 날짜 숨기기
        next2Label={null} // +1년 & +10년 이동 버튼 숨기기
        prev2Label={null} // -1년 & -10년 이동 버튼 숨기기
        minDetail="year" // 10년단위 년도 숨기기
      />
    </div>
  );
};
