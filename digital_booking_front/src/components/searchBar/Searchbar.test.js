import { render, fireEvent, act, getByText } from "@testing-library/react";
import SearchBar from "./SearchBar.jsx";
import '@testing-library/jest-dom'



describe("SearchBar", () => {
  it("clicking on location input opens DropdownPlaces", () => {
    const { getByTestId, getByText } = render(<SearchBar />);

    const input = getByTestId("search-location-input");

    act(() => {
      fireEvent.click(input);
    });
    setTimeout(2000)
    const dropdown =getByTestId('dropdown-places');

    expect(dropdown).toBeInTheDocument  });

  it("clicking on calendar input opens DropdownCalendar", () => {
    const { getByPlaceholderText, getByTestId } = render(<SearchBar />);
    const input = getByPlaceholderText("Check in - Check out");

    act(() => {

      fireEvent.click(input);
    });

    const dropdown = getByTestId("dropdown-calendar");

    expect(dropdown).toBeInTheDocument();
  });

  it("clicking outside of SearchBar closes dropdowns", () => {
    const { getByPlaceholderText, getByTestId, container } = render(<SearchBar />);
    const inputPlaces = getByTestId("search-location-input");
    const inputCalendar =getByPlaceholderText("Check in - Check out");

    act(() => {
      fireEvent.click(inputPlaces);
      fireEvent.click(inputCalendar)
    });

    const dropdownPlaces = getByTestId("dropdown-places");
    const dropCalendar = getByTestId('dropdown-calendar')
    

    expect(dropdownPlaces).toBeInTheDocument();
    

    act(() => {
      fireEvent.mouseDown(container);
    });

    expect(dropdownPlaces).not.toBeInTheDocument();
    expect(dropCalendar).not.toBeInTheDocument();
    
   

  });

  it("clicking Buscar button triggers search", () => {
    const { getByText } = render(<SearchBar />);
    const button = getByText("Buscar");

    act(() => {
      fireEvent.click(button);
    });

    // Add your own assertion here
  });
});
