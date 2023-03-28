def solution(gems):
    n = len(set(gems))  # 보석의 종류 수
    gem_dict = {gems[0]: 1}
    start, end = 0, 0
    cart = [gems[0]]

    ans = [0, len(gems)-1]  # 정답 초기값 설정

    while start < len(gems) and end < len(gems):
        if len(gem_dict) == n:  # 모든 종류의 보석을 포함할 경우
            if end - start < ans[1] - ans[0]:  # 더 짧은 구간일 경우 갱신
                ans = [start, end]

            if gem_dict[gems[start]] == 1:  # start 보석 개수가 1이면 딕셔너리에서 제거
                del gem_dict[gems[start]]
            else:
                gem_dict[gems[start]] -= 1

            start += 1  # start 인덱스 이동

        else:  # 모든 종류의 보석을 아직 포함하지 않을 경우
            end += 1  # end 인덱스 이동
            if end == len(gems):
                break

            cart.append(gems[end])
            if gems[end] in gem_dict:
                gem_dict[gems[end]] += 1
            else:
                gem_dict[gems[end]] = 1

    return [ans[0]+1, ans[1]+1]  # 1-based index로 변환하여 반환
