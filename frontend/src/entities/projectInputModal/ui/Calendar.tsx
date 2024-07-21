import { useState } from 'react';
import Calendars from 'react-calendar';
import '../Calendar.css';
import moment from 'moment';
import useStore from '../../../shared/store/store.ts';

// type ValuePiece = Date | null;
// type Value = ValuePiece | [ValuePiece, ValuePiece];

export const Calendar = ({ onChange, dateKey }: any) => {
  // const today = new Date();
  // const [date, setDate] = useState<Value>(today);
  const { startDate, endDate } = useStore();

  const createDate = (date: string): Date => {
    return date === '' ? new Date() : new Date(date);
  };
  const predate = dateKey === 'start' ? createDate(startDate) : createDate(endDate);
  const [oldDate, setOldData] = useState<Date>(predate);

  // console.log(date); //Wed Jul 10 2024 19:53:38 GMT+0900

  const handleDateChange = (selectedDate: any) => {
    onChange(selectedDate);
    setOldData(selectedDate);
  };

  return (
    <div className="w-max absolute mt-[3.5rem]">
      <Calendars
        value={oldDate}
        onChange={handleDateChange}
        formatDay={(_, oldDate) => moment(oldDate).format('D')} // 일 제거 숫자만 보이게
        formatYear={(_, oldDate) => moment(oldDate).format('YYYY')} // 네비게이션 눌렀을때 숫자 년도만 보이게
        formatMonthYear={(_, oldDate) => moment(oldDate).format('YYYY. MM')} // 네비게이션에서 2023. 12 이렇게 보이도록 설정
        calendarType="gregory" // 일요일 부터 시작
        showNeighboringMonth={false} // 전달, 다음달 날짜 숨기기
        next2Label={null} // +1년 & +10년 이동 버튼 숨기기
        prev2Label={null} // -1년 & -10년 이동 버튼 숨기기
        minDetail="year" // 10년단위 년도 숨기기
      />
    </div>
  );
};
